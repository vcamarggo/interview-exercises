package com.interview.sde.designpatterns.proxy;

public class DebitCard extends Card {
    DebitCard(Account account) {
        super(account);
    }

    @Override
    public void pay(int amount) {
        //validate transaction history as proxy behavior
        account.pay(amount);
    }
}
