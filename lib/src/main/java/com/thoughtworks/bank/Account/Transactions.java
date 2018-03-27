package com.thoughtworks.bank.Account;

import java.util.ArrayList;

public class Transactions {
    protected ArrayList<Transaction> transactions;

    public Transactions() {
        this.transactions = new ArrayList<Transaction>();
    }

    public void debit(Money amount, String to) throws InvalidAmountException {
        Transaction debit = new Debit(amount,to);
        transactions.add(debit);
    }

    public void credit(Money amount, String from) throws InvalidAmountException {
        Transaction credit = new Credit(amount, from);
        transactions.add(credit);
    }

    public Transactions getTransactionsAbove(Money money) {
        Transactions transactions=new Transactions();
        for (Transaction transaction : this.transactions){
            if (transaction.getAmount()>money.getMoney()){
                transactions.transactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getTransactionsBelow(Money money) {
        Transactions transactions=new Transactions();
        for (Transaction transaction : this.transactions){
            if (transaction.getAmount()<money.getMoney()){
                transactions.transactions.add(transaction);
            }
        }
        return transactions;
    }
}
