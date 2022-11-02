package com.interview.sde.java.designpatterns.proxy;

public class CreditCard extends Card {
    CreditCard(Account account) {
        super(account);
    }

    @Override
    public void pay(int amount) {
        //validate CVV  as proxy behavior
        account.pay(amount + 10);
    }
}
