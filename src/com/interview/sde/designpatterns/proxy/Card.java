package com.interview.sde.designpatterns.proxy;

public abstract class Card implements PaymentMethod {
    Account account;

    Card(Account account) {
        this.account = account;
    }


}
