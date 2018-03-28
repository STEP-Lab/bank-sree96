package com.thoughtworks.bank.Account;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
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
        Transactions tr = transactions.getTransactionsAbove(new Money(5000));
        Credit cr1= new Credit(new Date(),new Money(10000),"sree");
        Credit cr2 = new Credit(new Date(), new Money(6000), "sree");
        Debit db1 = new Debit(new Date(), new Money(5500), "sree");
        assertThat(tr.transactions,hasItems(cr1,cr2,db1));
    }
    @Test
    public void shouldReturnTransactionsBelowALimitOfAmount() throws InvalidAmountException {
        transactions.credit(new Money(10000),"sree");
        transactions.credit(new Money(1000),"sree");
        transactions.credit(new Money(6000),"sree");
        transactions.debit(new Money(5500),"sree");
        Transactions tr =transactions.getTransactionsBelow(new Money(6000));
        Credit credit = new Credit(new Date(), new Money(1000), "sree");
        Debit debit = new Debit(new Date(), new Money(5500), "sree");
        assertThat(tr.transactions,hasItems(credit,debit));
    }
    @Test
    public void shouldReturnTransactionsOfCreditType() throws InvalidAmountException {
        transactions.credit(new Money(10000),"sree");
        transactions.credit(new Money(6000),"sree");
        transactions.debit(new Money(5500),"sree");
        Transactions tr =transactions.getCreditTransactions();
        Credit cr1 = new Credit(new Date(), new Money(10000), "sree");
        Credit cr2 = new Credit(new Date(), new Money(6000), "sree");
        assertThat(tr.transactions,hasItems(cr1,cr2));
    }
    @Test
    public void shouldReturnTransactionsOfDebitType() throws InvalidAmountException {
        transactions.credit(new Money(10000),"sree");
        transactions.debit(new Money(600),"sree");
        transactions.debit(new Money(5500),"sree");
        Transactions tr =transactions.getDebitTransactions();
        Debit db1 = new Debit(new Date(), new Money(5500), "sree");
        Debit db2 = new Debit(new Date(), new Money(600), "sree");
        assertThat(tr.transactions,hasItems(db1,db2));
    }

    @Test
    public void shouldWriteAllTransactionDetailsToCSVFile() throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException {
        ArrayList<String> result  = new ArrayList<>();
        transactions.credit(new Money(10000),"sree");
        transactions.debit(new Money(600),"sree");
        transactions.debit(new Money(5500),"sree");
        Credit cr1 = new Credit(new Date(), new Money(10000), "sree");
        Debit db1 = new Debit(new Date(), new Money(5500), "sree");
        Debit db2 = new Debit(new Date(), new Money(600), "sree");
        transactions.writeToCsv(new PrintWriter("allTransactions.csv","UTF-8"));
        PrintWriter writer = new PrintWriter("allTransactions.csv","UTF-8") {
            @Override
            public void println(String s) {
                super.println(s);
                System.out.println(s);
                result.add(s);
            }
        };
        transactions.print(writer);
        writer.close();
        assertThat(result,hasItems(cr1.getInCsv(),db1.getInCsv(),db2.getInCsv()));
    }
}
