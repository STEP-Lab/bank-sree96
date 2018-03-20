package com.thoughtworks.bank.Account;

public class InvalidAccountNumberException extends Throwable {
    public InvalidAccountNumberException() {
        super("Invalid account number");
    }
}
