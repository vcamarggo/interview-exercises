package com.interview.sde.mock.coffeemachine.payment;

import java.util.List;

class PaymentProcessor implements IPaymentProcessor {

    Integer beverage;

    @Override
    public double processPayment(final Integer beverageId, final List<IPayment> payments) {
        double remainingToPay = getBeveragePrice(beverage);
        for (IPayment payment : payments) {
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
