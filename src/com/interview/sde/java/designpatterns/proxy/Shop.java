package com.interview.sde.java.designpatterns.proxy;

public class Shop {
    void charge(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
}
