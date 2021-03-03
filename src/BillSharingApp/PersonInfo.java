package BillSharingApp;

import java.util.HashMap;
import java.util.Map;

public class PersonInfo {
    private String personId;
    private String personName;
    private final Map<GroupInfo, Integer> currBalance;
    private int overallBalance;

    public PersonInfo(String personId, String personName) {
        this.personId = personId;
        this.personName = personName;
        this.currBalance = new HashMap<>();
        this.overallBalance = 0;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Map<GroupInfo, Integer> getBalance() {
        return currBalance;
    }

    public int getOverallBalance() {
        overallBalance = 0;
        for (Integer currBalance : currBalance.values())
            overallBalance += currBalance;
        return overallBalance;
    }

    public void setOverallBalance(int balance) {
        this.overallBalance = balance;
    }
}
