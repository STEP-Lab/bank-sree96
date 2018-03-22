package com.thoughtworks.bank.Account;

import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class AccountNumber {
    public AccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (!Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber))) {
            throw new InvalidAccountNumberException();
        }
    }
}
