package com.thoughtworks.bank.Account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountNumberTest {
    @Test
    public void shouldCreateAnAccountNumber() throws InvalidAccountNumberException {
        AccountNumber accountNumber = new AccountNumber("1234-1234");
        assertThat(accountNumber.getAccountNumber(),is("1234-1234"));
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInvaidAccountNumberExceptionForInvalidAccountNumberWithLessDigits() throws InvalidAccountNumberException {
        new AccountNumber("123-1233");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInlaidAccountNumberExceptionForInvalidAccountNumberWithAlphabets() throws InvalidAccountNumberException {
        new AccountNumber("aaaa-1233");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInlaidAccountNumberExceptionForInvalidAccountNumberWithoutHyphen() throws InvalidAccountNumberException {
        new AccountNumber("12341233");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void shouldThrowInvaidAccountNumberExceptionForInvalidAccountNumberWithAlphaNumericValue() throws InvalidAccountNumberException {
        new AccountNumber("1a3b-1233");
    }
}
