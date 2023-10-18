package org.example.model;

import java.util.UUID;

public abstract class BankAccount {
    private String accountID;
    private double balance;
    private String currency;
    private AccountStatus status;

    public BankAccount(){
        this.accountID = UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
    }

    public BankAccount(String currency, double balance){
        this();
        this.currency = currency;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID='" + accountID + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public abstract String getType();
    public final void print(){
        System.out.println("FINAL METHODE");
    }
}
