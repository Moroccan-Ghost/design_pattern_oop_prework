package org.example.business;

import org.example.exceptions.AccountNotFoundException;
import org.example.exceptions.BalanceNotSufficient;
import org.example.model.BankAccount;

import java.util.List;
import java.util.function.Predicate;

public interface BankAccountService {
    BankAccount addBankAccount(BankAccount bankAccount);
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void crediter(String accountId, double amount) throws AccountNotFoundException;
    void debiter(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficient;
    void tansfere(String accountSource, String accountDestination, double amount) throws BalanceNotSufficient, AccountNotFoundException;
    List<BankAccount> getSavingAccounts();
    List<BankAccount> getCurrentAccounts();
    double getTotalBalance();
    List<BankAccount> searchAccounts(Predicate<BankAccount> filter);

}
