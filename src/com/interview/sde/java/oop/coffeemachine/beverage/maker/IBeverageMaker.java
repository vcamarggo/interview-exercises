package com.interview.sde.java.oop.coffeemachine.beverage.maker;

import com.interview.sde.java.oop.coffeemachine.beverage.Beverage;

public interface IBeverageMaker {

    void makeBeverage(final Integer beverageId);

    Beverage getBeverage();
}
