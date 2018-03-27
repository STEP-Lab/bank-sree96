package com.thoughtworks.bank.Account;

import java.util.Date;

public class Debit extends Transaction{
    public Debit(Date date, Money amount, String to) throws InvalidAmountException {
        super(date,amount,to);
    }
    protected Debit(Money amount, String to) throws InvalidAmountException {
        this(new Date(),amount,to);
    }
}
