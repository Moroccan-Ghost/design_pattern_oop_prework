package org.example.business;

import org.example.model.BankAccount;

@FunctionalInterface
public interface Condition {
    boolean test(BankAccount bankAccount);
}
