package com.thoughtworks.bank.Account;

import java.util.Date;

public class Credit extends Transaction{
    public Credit(Date date, Money amount, String from) throws InvalidAmountException {
        super(date,amount,from,"credit");
    }
    protected Credit(Money amount, String from) throws InvalidAmountException {
        this(new Date(),amount,from);
    }
}
