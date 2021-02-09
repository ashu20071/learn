package BillSharingApp;

import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        DbClass db = new DbClass();
        UserService userService = new UserService(db);
        BillService billService = new BillService(db);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bill Sharing Application\n*\n*\n*\n");

        String exitCondition = "";
        while (!exitCondition.equals("exit")) {
            System.out.println("\nCurrent person list:");
            if (db.getPersonInfoMap().isEmpty())
                System.out.println("There are no persons added. Choose add new person to add!");
            else
                db.printPersonInfoMap();

            System.out.println("\nCurrent Groups:");
            if (db.getGroupInfoMap().isEmpty())
                System.out.println("There are no groups yet. Select add person to group to create one!");
            else
                db.printGroupInfoMap();

            System.out.println("\nGenerated bills:");
            if (db.getBillInfoMap().isEmpty())
                System.out.println("There are no bills generated. Choose generate new bill to add!");
            else
                db.printBillInfoMap();

            System.out.print("\n\nNote: There must be persons added in groups to generate bill");
            System.out.println("\nChoose what you want to do from the following:");
            System.out.println("1. Add new person\n2. Add person to a group\n3. Generate new bill\n4. Exit application");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    try {
                        userService.addPerson();
                    } catch (Exception exception) {
                        System.out.println(exception+"\n\n");
                        //exception.printStackTrace();
                    }
                }
                case 2 -> {
                    try {
                        userService.addToGroup();
                    } catch (Exception exception) {
                        System.out.println(exception+"\n\n");
                        //exception.printStackTrace();
                    }
                }
                case 3 -> {
                    try {
                        billService.generateBill();
                    } catch (Exception exception) {
                        System.out.println(exception+"\n\n");
                        //exception.printStackTrace();
                    }
                }
                case 4 -> {
                    exitCondition = "exit";
                    System.out.println("\nThank you for using Bill Sharing application!");
                }
                default -> System.out.println("Incorrect input");
            }
        }
    }
}
