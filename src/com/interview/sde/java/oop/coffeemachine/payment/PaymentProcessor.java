package com.interview.sde.java.oop.coffeemachine.payment;

import java.util.List;

class PaymentProcessor implements IPaymentProcessor {

    Integer beverage;

    @Override
    public double processPayment(final Integer beverageId, final List<IPaymentMethod> payments) {
        double remainingToPay = getBeveragePrice(beverage);
        for (IPaymentMethod payment : payments) {
            remainingToPay -= payment.pay(remainingToPay);
        }
        return remainingToPay;
    }

    @Override
    public double refundPayment() {
        //Not handling error in case beverage has been refunded already
        return getBeveragePrice(beverage);
    }

    //Out of scope
    double getBeveragePrice(final Integer beverage) {
        throw new UnsupportedOperationException();
    }
}
