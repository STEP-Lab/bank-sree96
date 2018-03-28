package com.thoughtworks.bank.Account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MoneyTest {
    @Test(expected = InvalidAmountException.class)
    public void shouldThrowInvalidAmountExceptionForZero() throws InvalidAmountException {
        new Money(0);
    }
    @Test(expected = InvalidAmountException.class)
    public void shouldThrowInvalidAmountExceptionForNegativeAmount() throws InvalidAmountException {
        new Money(-1000);
    }

    @Test
    public void shouldCreateAMoneyObject() throws InvalidAmountException {
        Money money = new Money(1000);
        assertThat(money.getMoney(),is(1000.0));
    }
}