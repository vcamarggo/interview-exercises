package com.interview.sde.mock.coffeemachine.payment;

public class Cash implements IPayment {
    //value of a given coin
    private double value;

    //return amount of funds in the
    public double pay(final double amount) {
        return Math.max(value, value - amount);
    }

}
