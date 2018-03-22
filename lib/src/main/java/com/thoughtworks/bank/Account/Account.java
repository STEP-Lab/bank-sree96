package com.thoughtworks.bank.Account;


public class Account {
    private final AccountNumber accountNumber;
    private double balance;
    public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        if (balance<2000) {
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void debitAmount(double amount) throws InvalidDebitAmountException {
        balance = balance - amount;
        if (balance<2000) {
            balance  = balance + amount;
            throw new InvalidDebitAmountException();
        }
    }

    public void creditAmount(double amount) {
        balance +=amount;
    }
}