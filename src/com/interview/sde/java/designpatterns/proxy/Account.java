package com.interview.sde.java.designpatterns.proxy;

public class Account implements PaymentMethod {
    int balance;

    Account(int balance) {
        this.balance = balance;
    }

    @Override
    public void pay(int amount) {
        balance -= amount;
    }
}
