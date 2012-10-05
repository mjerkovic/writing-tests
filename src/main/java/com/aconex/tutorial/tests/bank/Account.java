package com.aconex.tutorial.tests.bank;

import com.google.common.base.Preconditions;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        Preconditions.checkArgument(balance >= amount, "Insufficient funds to debit");
        balance -= amount;
    }

    public double balance() {
        return balance;
    }

}
