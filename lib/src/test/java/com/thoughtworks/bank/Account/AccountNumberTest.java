package com.thoughtworks.bank.Account;

import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInvaidAccountNumberExceptionForInvalidAccountNumber() throws InvalidAccountNumberException {
        new AccountNumber("123-1233");
    }
}
