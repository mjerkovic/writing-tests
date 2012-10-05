package com.aconex.tutorial.tests.bank;

public class Transaction {

    public static void transferFunds(Account from, Account to, double amount) {
        from.debit(amount);
        to.credit(amount);
    }

}
