package org.example.business;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.BalanceNotSufficient;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService{
    private List<BankAccount> bankAccounts = new ArrayList<>();
    @Override
    public BankAccount addBankAccount(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccounts;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
        return bankAccounts.stream().filter(acc -> acc.getAccountID().equals(id))
                .findFirst()
                .orElseThrow(()-> new AccountNotFoundException(String.format("BankAccount not found ",id)));
    }

    @Override
    public void addRandomData(int size) {
        for (int i = 0; i <= size; i++) {
            BankAccount account;
            if(Math.random() > 0.5){
                account = new CurrentAccount("MAD",Math.random()*10000,Math.random()*50000);
            }else{
                account = new SavingAccount("Euro",Math.random()*10000,Math.random()*10);
            }
            bankAccounts.add(account);
        }
    }

    @Override
    public void crediter(String accountId, double amount) throws AccountNotFoundException{
        BankAccount accountById =  getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }

    @Override
    public void debiter(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficient{
        BankAccount accountById =  getAccountById(accountId);
        if(amount > accountById.getBalance()){
            throw new BalanceNotSufficient(String.format("BankAccount not found"));
        }else{
            accountById.setBalance(accountById.getBalance()-amount);
        }
    }

    @Override
    public void tansfere(String accountSource, String accountDestination, double amount) throws BalanceNotSufficient, AccountNotFoundException {
        debiter(accountSource, amount);
        crediter(accountDestination, amount);
    }

    @Override
    public List<BankAccount> getSavingAccounts() {
        return bankAccounts.stream()
                .filter(acc -> acc instanceof SavingAccount).collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> getCurrentAccounts() {
        return bankAccounts.stream()
                .filter(acc -> acc instanceof CurrentAccount).collect(Collectors.toList());
    }

    @Override
    public double getTotalBalance() {
        return bankAccounts.stream()
                .map(acc -> acc.getBalance())
                .reduce(0.0,(a,v)->a+v);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> filter) {
        List<BankAccount> res = new ArrayList<>();
        for(BankAccount acc:bankAccounts){
            if(filter.test(acc)){
                res.add(acc);
            }
        }
        return res;
    }

}
