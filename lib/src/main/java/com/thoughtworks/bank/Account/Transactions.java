package com.thoughtworks.bank.Account;

import java.util.ArrayList;

public class Transactions {
    protected ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<Transaction>();
    }

    public void debit(double amount, String to) {
        Transaction debit = new Debit(amount,to);
        transactions.add(debit);
    }

    public void credit(double amount, String from) {
        Transaction credit = new Credit(amount, from);
        transactions.add(credit);
    }
}
