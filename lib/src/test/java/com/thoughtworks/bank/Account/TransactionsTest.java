package com.thoughtworks.bank.Account;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    @Test
    public void shouldHaveADebitTransactionInAllTransactions() {
        Transactions transactions = new Transactions();
        transactions.debit(100,"sree");
        assertThat(transactions.transactions,hasItem(new Debit(new Date(),100,"sree")));
    }

    @Test
    public void shouldHaveACreditTransactionInAllTransactions() {
        Transactions transactions = new Transactions();
        transactions.credit(100,"sree");
        assertThat(transactions.transactions,hasItem(new Credit(new Date(),100,"sree")));
    }
}
