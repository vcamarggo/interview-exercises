package com.interview.sde.java.oop.coffeemachine.beverage.maker.strategy;

import com.interview.sde.java.oop.coffeemachine.beverage.Beverage;

public interface IBeveragePreparationStrategy {
    Beverage make();
}
