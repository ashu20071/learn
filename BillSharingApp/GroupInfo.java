package BillSharingApp;

import java.util.HashSet;
import java.util.Set;

public class GroupInfo {
    private int groupId;
    private String groupName;
    private final Set<PersonInfo> members;

    public GroupInfo(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = new HashSet<>();
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<PersonInfo> getMembers() {
        return members;
    }

    public void addMember(PersonInfo newPerson) {
        members.add(newPerson);
    }
}
