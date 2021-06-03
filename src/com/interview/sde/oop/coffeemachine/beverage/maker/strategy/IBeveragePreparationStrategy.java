package com.interview.sde.oop.coffeemachine.beverage.maker.strategy;

import com.interview.sde.oop.coffeemachine.beverage.Beverage;

public interface IBeveragePreparationStrategy {
    Beverage make();
}
