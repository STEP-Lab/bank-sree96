package com.thoughtworks.bank.Account;

public class InvalidAmountException extends Throwable {
    public InvalidAmountException() {
        super("Invalid amount");
    }
}
