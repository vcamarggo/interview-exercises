package com.interview.sde.mock.coffeemachine.payment;

import java.util.List;

class ConcretePaymentProcessor implements IPaymentProcessor {

    Integer beverage;

    @Override
    public double processPayment(final Integer beverageId, final List<IPayment> payments) {
        double remainingToPay = getBeveragePrice(beverage);
        for (IPayment payment : payments) {
            remainingToPay -= payment.pay(remainingToPay);
        }
        return 0;
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
