package org.example.model;

public class CurrentAccount extends BankAccount{
    private double overDraft;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String currency, double balance, double overDraft) {
        super(currency, balance);
        this.overDraft = overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    @Override
    public String toString(){
        return "Current Account , overdraft = "+overDraft + super.toString();
    }

    @Override
    public String getType() {
        return "CURRENT";
    }
}
