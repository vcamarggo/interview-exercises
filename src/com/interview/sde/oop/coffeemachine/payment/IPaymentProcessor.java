package com.interview.sde.oop.coffeemachine.payment;

import java.util.List;

public interface IPaymentProcessor {
    double processPayment(final Integer beverageId, final List<IPayment> IPayment);

    double refundPayment();

}
