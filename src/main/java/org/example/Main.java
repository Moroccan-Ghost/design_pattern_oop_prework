package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.model.BankAccount;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.CurrentAccount;
import org.example.model.SavingAccount;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        BankAccount [] bankAccounts = new BankAccount[4];
//        bankAccounts[0] = new BankAccount("USD",5100);
//        bankAccounts[1] = new BankAccount("MAD",8500);
//        bankAccounts[2] = new BankAccount("MAD",9400);
//        bankAccounts[3] = new BankAccount("EUR",5000);
//        for(BankAccount account:bankAccounts){
//            System.out.println(account.toString());
//        }

//        ArrayList<BankAccount> bankAccountArrayList = new ArrayList<>();
//        bankAccountArrayList.add(new BankAccount("USD",5100));
//        bankAccountArrayList.add(new BankAccount("MAD",8500));
//        bankAccountArrayList.add(new BankAccount("MAD",9400));
//        bankAccountArrayList.add(new BankAccount("EUR",5000));
//        for(BankAccount account:bankAccountArrayList){
//            System.out.println(toJson(account));
//        }


        CurrentAccount currentAccount = new CurrentAccount("EUR",400,100);
        System.out.println(toJson(currentAccount));

        SavingAccount savingAccount = new SavingAccount("EUR",400,10);
        System.out.println(toJson(savingAccount));


    }

    public static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}