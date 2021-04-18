package com.interview.sde.mock.coffeemachine.beverage.maker.strategy;

import com.interview.sde.mock.coffeemachine.beverage.Beverage;

public interface IBeveragePreparationStrategy {
    Beverage make();
}
