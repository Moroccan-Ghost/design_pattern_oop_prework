package org.example.exceptions;

public class BalanceNotSufficient extends Exception{
    public BalanceNotSufficient(String message){
        super(message);
    }
}
