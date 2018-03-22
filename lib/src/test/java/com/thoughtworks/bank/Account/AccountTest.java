package com.thoughtworks.bank.Account;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() throws MinimumBalanceException, InvalidAccountNumberException {
        account = new Account(new AccountNumber("1234-5678"), 2000);
    }

    @Test
    public void shouldGetBalance() {
        assertThat(account.getBalance(), is(2000.0));
    }
    @Test(expected = MinimumBalanceException.class)
    public void shouldThrowMinimumBalanceExceptionIfBalanceIsLessThanMinimum() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account(new AccountNumber("1234-5678"),200);
    }

    @Test
    public void shouldDebitAnAmountFromAccount() throws MinimumBalanceException, InvalidAccountNumberException, InvalidDebitAmountException {
        account = new Account(new AccountNumber("1234-5678"),3000);
        assertThat(account.getBalance(),is(3000.0));
        account.debitAmount(1000);
        assertThat(account.getBalance(),is(2000.0));
    }

    @Test(expected = InvalidDebitAmountException.class)
    public void shouldThrowInvalidDebitAmountExceptionIfDebitIsInvalid() throws InvalidDebitAmountException {
        account.debitAmount(1000);
    }

    @Test
    public void shouldCreditAmountToAnAccount() {
        assertThat(account.getBalance(),is(2000.0));
        account.creditAmount(1000);
        assertThat(account.getBalance(),is(3000.0));
    }
}
