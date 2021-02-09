package BillSharingApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbClass {
    private final Map<Integer, GroupInfo> groupInfoMap;
    private final Map<String, PersonInfo> personInfoMap;
    private final Map<String , BillInfo> billInfoMap;

    public DbClass() {
        this.groupInfoMap = new HashMap<>();
        this.personInfoMap = new HashMap<>();
        this.billInfoMap = new HashMap<>();
    }

    public Map<Integer, GroupInfo> getGroupInfoMap() {
        return groupInfoMap;
    }

    public Map<String, PersonInfo> getPersonInfoMap() {
        return personInfoMap;
    }

    public Map<String, BillInfo> getBillInfoMap() {
        return billInfoMap;
    }

    public void addGroup(GroupInfo groupInfo) {
        groupInfoMap.put(groupInfo.getGroupId(), groupInfo);
    }

    public void addPerson(PersonInfo personInfo) {
        personInfoMap.put(personInfo.getPersonId(), personInfo);
    }

    public void addBill(BillInfo billInfo) {
        billInfoMap.put(billInfo.getBillDescription(), billInfo);
    }

    public void printGroupInfoMap() {
        for (Map.Entry<Integer, GroupInfo> groupInfoEntry : groupInfoMap.entrySet()) {
            System.out.print(groupInfoEntry.getKey()+" : "+groupInfoEntry.getValue().getGroupName()+" : [");
            for (PersonInfo persons : groupInfoEntry.getValue().getMembers()) {
                System.out.print(" "+persons.getPersonName()+":"+persons.getBalance().get(groupInfoEntry.getValue())+" ");
            }
            System.out.println("]");
        }
    }

    public void printPersonInfoMap() {
        for (Map.Entry<String, PersonInfo> personInfoEntry : personInfoMap.entrySet()) {
            System.out.println(personInfoEntry.getKey()+" : "+personInfoEntry.getValue().getPersonName()+
                    ": Overall Balance = "+personInfoEntry.getValue().getOverallBalance());
        }
    }

    public void printBillInfoMap() {
        for (Map.Entry<String, BillInfo> billInfoEntry : billInfoMap.entrySet()) {
            System.out.print(billInfoEntry.getKey()+": Amount = "+billInfoEntry.getValue().getAmount()+"\nGroup Id: "+
                    billInfoEntry.getValue().groupInfo.getGroupId()+"\nContributions: [");
            for (Map.Entry<BillInfo, List<Contributions>> contributionList : billInfoEntry.getValue().contributionList.entrySet()) {
                for (Contributions contributions : contributionList.getValue()) {
                    System.out.print(" "+contributions.contributor+":"+contributions.contribution+" ");
                }
                System.out.print("]\nPaidBy: [");
            }
            for (Map.Entry<BillInfo, List<Payment>> paymentList : billInfoEntry.getValue().paymentList.entrySet()) {
                for (Payment payment : paymentList.getValue()) {
                    System.out.print(" "+payment.paidBy+":"+payment.amountPaid+" ");
                }
                System.out.println("]\n");
            }
        }
    }
}
