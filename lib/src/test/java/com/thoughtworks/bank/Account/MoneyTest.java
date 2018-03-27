package com.thoughtworks.bank.Account;

import org.junit.Test;


public class MoneyTest {
    @Test(expected = InvalidAmountException.class)
    public void shouldThrowInvalidAmountExceptionForZero() throws InvalidAmountException {
        new Money(0);
    }
    @Test(expected = InvalidAmountException.class)
    public void shouldThrowInvalidAmountExceptionForNegativeAmount() throws InvalidAmountException {
        new Money(-1000);
    }
}