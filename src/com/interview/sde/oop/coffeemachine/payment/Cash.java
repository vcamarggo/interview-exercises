package com.interview.sde.oop.coffeemachine.payment;

public class Cash implements IPayment {
    //value of a given coin
    private double value;

    //return amount of funds in the
    public double pay(final double amountToPay) {
        double diff = amountToPay - value ;
        return diff <= 0 ? amountToPay : diff;
    }

}
