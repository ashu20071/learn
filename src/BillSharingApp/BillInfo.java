package BillSharingApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillInfo {
    private String billDescription;
    private int amount;
    GroupInfo groupInfo;
    Map<BillInfo, List<Contributions>> contributionList;
    Map<BillInfo, List<Payment>> paymentList;

    public BillInfo(String billDescription, int amount, GroupInfo groupInfo) {
        this.billDescription = billDescription;
        this.amount = amount;
        this.groupInfo = groupInfo;
        this.contributionList = new HashMap<>();
        this.paymentList = new HashMap<>();
    }

    public String getBillDescription() {
        return billDescription;
    }

    public void setBillDescription(String billDescription) {
        this.billDescription = billDescription;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
