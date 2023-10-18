package org.example;

import org.example.business.BankAccountService;
import org.example.business.BankAccountServiceImpl;
import org.example.business.Condition;
import org.example.exceptions.AccountNotFoundException;
import org.example.model.BankAccount;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;
import org.example.utils.DataTransformation;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args){
        BankAccountService bankAccountService = new BankAccountServiceImpl();
//        CurrentAccount currentAccount = new CurrentAccount("MAD",50000,500);
//        bankAccountService.addBankAccount(currentAccount);
//        bankAccountService.addBankAccount(new SavingAccount("MAD",7000,10));

//        List<BankAccount> allAccounts = bankAccountService.getAllAccounts();
//        allAccounts.forEach((account)->{
//            System.out.println(account.toString());
//        });

//        BankAccount accountById  = null;
//        try {
//            accountById = bankAccountService.getAccountById(currentAccount.getAccountID());
//        } catch (AccountNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println(accountById.toString());

        bankAccountService.addRandomData(10);

        List<BankAccount> bankAccounts =  bankAccountService.searchAccounts(bankAccount -> (bankAccount.getBalance() > 1000));
        bankAccounts.stream()
                .map(DataTransformation::toJson)
                .forEach(System.out::println);
    }
}
