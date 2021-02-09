package BillSharingApp;

public class Contributions {
    String contributor;
    int contribution;

    public Contributions(int contribution, String contributor) {
        this.contribution = contribution;
        this.contributor = contributor;
    }
}

class Payment {
    String paidBy;
    int amountPaid;

    public Payment(int amountPaid, String paidBy) {
        this.amountPaid = amountPaid;
        this.paidBy = paidBy;
    }
}
