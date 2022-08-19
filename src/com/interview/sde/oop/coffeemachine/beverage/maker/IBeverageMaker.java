package com.interview.sde.oop.coffeemachine.beverage.maker;

import com.interview.sde.oop.coffeemachine.beverage.Beverage;

public interface IBeverageMaker {

    void makeBeverage(final Integer beverageId);

    Beverage getBeverage();
}
