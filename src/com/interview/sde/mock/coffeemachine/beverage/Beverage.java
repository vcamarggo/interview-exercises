package com.interview.sde.mock.coffeemachine.beverage;

public abstract class Beverage{

    protected double price;

    protected Beverage(final Double price){
        this.price = price;
    }

    double getPrice(){
        return this.price;
    }
}
