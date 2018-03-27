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

    public ArrayList<Transaction> getTransactionsAbove(Money money) {
        ArrayList<Transaction> transactions=new ArrayList<>();
        int length=this.transactions.size();
        for (int i=0;i<length;i++){
            if (this.transactions.get(i).getAmount()>money.getMoney()){
                transactions.add(this.transactions.get(i));
            }
        }
        return transactions;
    }
}
