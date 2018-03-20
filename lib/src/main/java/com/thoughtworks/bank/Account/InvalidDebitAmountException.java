package com.thoughtworks.bank.Account;

public class InvalidDebitAmountException extends Throwable {
    public InvalidDebitAmountException() {
        super("Debit amount greater than minimum balance");
    }
}
