package com.interview.sde.java.oop.coffeemachine.payment;

import java.util.List;

public interface IPaymentProcessor {
    double processPayment(final Integer beverageId, final List<IPaymentMethod> IPaymentMethod);

    double refundPayment();

}
