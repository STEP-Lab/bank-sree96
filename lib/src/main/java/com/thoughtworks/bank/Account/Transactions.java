package com.thoughtworks.bank.Account;

import java.io.PrintWriter;
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

    public Transactions getCreditTransactions() {
        Transactions transactions=new Transactions();
        for (Transaction transaction : this.transactions){
            if (transaction instanceof Credit){
                transactions.transactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transactions getDebitTransactions() {
        Transactions transactions=new Transactions();
        for (Transaction transaction : this.transactions){
            if (transaction instanceof Debit){
                transactions.transactions.add(transaction);
            }
        }
        return transactions;
    }

    public void print(PrintWriter writer) {
        for (Transaction transaction : transactions){
            writer.println(transaction.getInCsv());
        }
    }

    public void writeToCsv(PrintWriter writer) {
        String header = "date,type,amount,source\n";
        writer.print(header);
        for (Transaction transaction : transactions){
            String tr = transaction.getInCsv();
            writer.print(tr);
        }
        writer.close();
    }
}
