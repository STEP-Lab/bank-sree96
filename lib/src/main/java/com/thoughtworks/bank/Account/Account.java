package com.thoughtworks.bank.Account;

import java.util.regex.*;

import static java.lang.String.valueOf;

public class Account {
    private final String accountNumber;
    private double balance;
    public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        if (!Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber))) {
            throw new InvalidAccountNumberException();
        }
        this.accountNumber = accountNumber;
        if (balance<2000) {
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void debitAmount(double amount) throws InvalidDebitAmountException {
        balance = balance - amount;
        if (balance<2000) {
            balance  = balance + amount;
            throw new InvalidDebitAmountException();
        }
    }
}