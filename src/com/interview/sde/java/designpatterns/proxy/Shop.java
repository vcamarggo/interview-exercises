package com.interview.sde.designpatterns.proxy;

public class Shop {
    void charge(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
}
