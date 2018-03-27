package com.thoughtworks.bank.Account;


import java.util.Objects;

public class Money {
    private double money;

    public Money(double money) throws InvalidAmountException {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(double money) throws InvalidAmountException {
        if (money<=0){
            throw new InvalidAmountException();
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.money, money) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(money);
    }
}
