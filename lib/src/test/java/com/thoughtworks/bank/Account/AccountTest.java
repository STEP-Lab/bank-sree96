package com.thoughtworks.bank.Account;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException, InvalidAmountException {
        account = new Account(new AccountNumber("1234-5678"), new Money(2000));
    }

    @Test
    public void shouldGetBalance() throws InvalidAmountException {
        assertThat(account.getBalance(), is(new Money(2000.0)));
    }
    @Test(expected = MinimumBalanceException.class)
    public void shouldThrowMinimumBalanceExceptionIfBalanceIsLessThanMinimum() throws MinimumBalanceException, InvalidAccountNumberException, InvalidAmountException {
        new Account(new AccountNumber("1234-5678"),new Money(200));
    }

    @Test
    public void shouldDebitAnAmountFromAccount() throws MinimumBalanceException, InvalidAccountNumberException, InvalidDebitAmountException, InvalidAmountException {
        account = new Account(new AccountNumber("1234-5678"),new Money(3000));
        assertThat(account.getBalance(),is(new Money(3000.0)));
        account.debitAmount(new Money(1000));
        assertThat(account.getBalance(),is(new Money(2000.0)));
    }

    @Test(expected = InvalidDebitAmountException.class)
    public void shouldThrowInvalidDebitAmountExceptionIfDebitIsInvalid() throws InvalidDebitAmountException, InvalidAmountException {
        account.debitAmount(new Money(1000));
    }

    @Test
    public void shouldCreditAmountToAnAccount() throws InvalidAmountException {
        assertThat(account.getBalance(),is(new Money(2000.0)));
        account.creditAmount(new Money(1000));
        assertThat(account.getBalance(),is(new Money(3000.0)));
    }
}
