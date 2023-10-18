package org.example.model;

public class SavingAccount extends BankAccount{
    private double intersetRate;

    public SavingAccount(){
        super();
    }
    public SavingAccount(String currency, double balance, double intersetRate) {
        super(currency, balance);
        this.intersetRate = intersetRate;
    }
    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    @Override
    public String toString(){
        return "Saving Account , intersetRate = "+intersetRate + super.toString();
    }

    @Override
    public String getType() {
        return "SAVING";
    }
}
