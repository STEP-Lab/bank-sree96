package com.thoughtworks.bank.Account;


public class Account {
    private final AccountNumber accountNumber;
    private Money balance;
    public Account(AccountNumber accountNumber, Money balance) throws MinimumBalanceException {
        this.accountNumber = accountNumber;
        if (balance.getMoney()<2000) {
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public Money getBalance() {
        return balance;
    }

    public void debitAmount(Money amount) throws InvalidDebitAmountException {
        if (balance.getMoney()-amount.getMoney()<2000) {
            throw new InvalidDebitAmountException();
        }
        balance.setMoney(balance.getMoney()-amount.getMoney());
    }

    public void creditAmount(Money amount) {
        balance.setMoney(balance.getMoney()+amount.getMoney());
    }
}