package com.thoughtworks.bank.Account;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

    private Transactions transactions;

    @Before
    public void setUp() {
        transactions = new Transactions();
    }

    @Test
    public void shouldHaveADebitTransactionInAllTransactions() throws InvalidAmountException {
        transactions.debit(new Money(100),"sree");
        assertThat(transactions.transactions,hasItem(new Debit(new Date(),new Money(100),"sree")));
    }

    @Test
    public void shouldHaveACreditTransactionInAllTransactions() throws InvalidAmountException {
        transactions.credit(new Money(100),"sree");
        assertThat(transactions.transactions,hasItem(new Credit(new Date(),new Money(100),"sree")));
    }

    @Test
    public void shouldReturnTransactionsAboveALimitOfAmount() throws InvalidAmountException {
        transactions.credit(new Money(10000),"sree");
        transactions.credit(new Money(1000),"sree");
        transactions.credit(new Money(6000),"sree");
        transactions.debit(new Money(5500),"sree");
        assertThat(transactions.getTransactionsAbove(new Money(5000)),hasItem(new Credit(new Date(),new Money(10000),"sree")));
        assertThat(transactions.getTransactionsAbove(new Money(5000)),hasItem(new Credit(new Date(),new Money(6000),"sree")));
        assertThat(transactions.getTransactionsAbove(new Money(5000)),hasItem(new Debit(new Date(),new Money(5500),"sree")));
    }
}
