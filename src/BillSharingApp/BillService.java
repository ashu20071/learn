package BillSharingApp;

import java.util.ArrayList;
import java.util.Scanner;

public class BillService {
    Scanner scanner = new Scanner(System.in);
    DbClass db;

    public BillService(DbClass db) {
        this.db = db;
    }

    public void generateBill() {
        System.out.print("Enter bill description: ");
        String description = scanner.nextLine();
        if (db.getBillInfoMap().containsKey(description))
            throw new IllegalArgumentException("Bill already exists!");
        else {
            System.out.print("\nEnter total amount: ");
            int billAmount = Integer.parseInt(scanner.nextLine());
            System.out.print("\nEnter group for this bill: ");
            int groupId = Integer.parseInt(scanner.nextLine());
            if (!db.getGroupInfoMap().containsKey(groupId))
                throw new IllegalArgumentException("Group does not exist!");
            else {
                BillInfo newBill = new BillInfo(description, billAmount, db.getGroupInfoMap().get(groupId));
                newBill.contributionList.put(newBill, new ArrayList<>());
                newBill.paymentList.put(newBill, new ArrayList<>());
                System.out.println("\nEnter contributions:");
                for (PersonInfo contributors : db.getGroupInfoMap().get(groupId).getMembers()) {
                    System.out.print(contributors.getPersonName()+": ");
                    int contribution = Integer.parseInt(scanner.nextLine());
                    newBill.contributionList.get(newBill).add(new Contributions(contribution, contributors.getPersonId()));
                }
                System.out.print("\nBill paid by? (email): ");
                String paidBy = scanner.nextLine();
                System.out.print("Amount paid by "+db.getPersonInfoMap().get(paidBy).getPersonName()+": ");
                int paidAmount = Integer.parseInt(scanner.nextLine());
                newBill.paymentList.get(newBill).add(new Payment(paidAmount, paidBy));
                while (paidAmount < billAmount) {
                    System.out.print("\n and? ");
                    String anotherPayer = scanner.nextLine();
                    System.out.print("Amount paid by "+db.getPersonInfoMap().get(anotherPayer).getPersonName()+": ");
                    int anotherAmount = Integer.parseInt(scanner.nextLine());
                    newBill.paymentList.get(newBill).add(new Payment(anotherAmount, anotherPayer));
                    paidAmount += anotherAmount;
                }
                db.addBill(newBill);
                updateBalance(newBill, db.getGroupInfoMap().get(groupId));
                System.out.println("\nBill generated!\n");
            }
        }
    }

    private void updateBalance(BillInfo newBill, GroupInfo groupInfo) {
        for (Contributions contributions : db.getBillInfoMap().get(newBill.getBillDescription()).contributionList.get(newBill)) {
            int newBalance = 0;
            for (Payment payment : db.getBillInfoMap().get(newBill.getBillDescription()).paymentList.get(newBill)) {
                if (contributions.contributor.equals(payment.paidBy))
                    newBalance = payment.amountPaid - contributions.contribution;
            }
            newBalance = (newBalance == 0) ? (contributions.contribution * -1) : newBalance;
            Integer oldBalance = db.getPersonInfoMap().get(contributions.contributor).getBalance().get(groupInfo);
            newBalance = (oldBalance != null) ? newBalance + oldBalance : newBalance;
            db.getPersonInfoMap().get(contributions.contributor).getBalance().
                    put(db.getGroupInfoMap().get(groupInfo.getGroupId()), newBalance);

        }
    }
}
