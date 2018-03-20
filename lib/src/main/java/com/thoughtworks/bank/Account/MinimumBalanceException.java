package com.thoughtworks.bank.Account;

public class MinimumBalanceException extends Throwable{

    public MinimumBalanceException() {
        super("Insufficient minimum balance");
    }
}
