package com.thoughtworks.bank.Account;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void shouldRecordADebitTransaction() throws InvalidAmountException {
        Date date = new Date();
        Debit debit = new Debit(date, new Money(1000),"hari");
        assertThat(debit.getDate(),is(date));
    }
}
