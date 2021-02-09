package BillSharingApp;

import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);
    DbClass db;

    public UserService(DbClass db) {
        this.db = db;
    }

    public void addPerson() {
        System.out.print("\nEnter person email: ");
        String id = scanner.nextLine();
        System.out.print("\nEnter person name: ");
        PersonInfo newPerson = new PersonInfo(id, scanner.nextLine());
        if (db.getPersonInfoMap().containsKey(newPerson.getPersonId()))
            throw new IllegalArgumentException("Person already exists!");
        else
            db.addPerson(newPerson);
    }

    public void addToGroup() {
        System.out.println("Enter person email to be added");
        String personId = scanner.nextLine();
        if (!db.getPersonInfoMap().containsKey(personId))
            throw new IllegalArgumentException("Person does not exist!");
        else {
            System.out.println("Enter group ID in which person is to be added");
            int groupID = Integer.parseInt(scanner.nextLine());
            if (!db.getGroupInfoMap().containsKey(groupID)) {
                System.out.println("There seems to be no such group. Creating new group with this id");
                System.out.print("Please enter group name: ");
                String groupName = scanner.nextLine();
                GroupInfo newGroup = new GroupInfo(groupID, groupName);
                db.addGroup(newGroup);
            }
            db.getGroupInfoMap().get(groupID).addMember(db.getPersonInfoMap().get(personId));
            System.out.println();
            System.out.println("Person added to group\n\n");
        }
    }
}
