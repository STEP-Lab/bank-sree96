package com.thoughtworks.bank.Account;

import java.util.Date;
import java.util.Objects;

public abstract class Transaction {

    private final Date date;
    private Money amount;
    private final String source;

    public Transaction(Date date, Money amount, String source) throws InvalidAmountException {
        this.date = date;
        this.amount=new Money(amount.getMoney());
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount.getMoney(), amount.getMoney()) == 0 &&
                Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, source);
    }

    public double getAmount() {
        return amount.getMoney();
    }
}
