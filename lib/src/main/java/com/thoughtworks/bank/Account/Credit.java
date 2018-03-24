package com.thoughtworks.bank.Account;

import java.util.Date;

public class Credit extends Transaction{
    public Credit(Date date, double amount, String from) {
        super(date,amount,from);
    }
    protected Credit(double amount,String from){
        this(new Date(),amount,from);
    }
}
