package com.interview.sde.oop.coffeemachine.beverage.maker;

import com.interview.sde.oop.coffeemachine.beverage.Beverage;
import com.interview.sde.oop.coffeemachine.beverage.maker.strategy.IBeveragePreparationStrategy;

class Machine implements IBeverageMaker {
    IBeveragePreparationStrategy strategy;

    Beverage beverage;

    Machine() {
    }

    public void makeBeverage(final Integer beverageType) {
        //A Factory can be implemented here
        this.strategy = null; // Factory.getBeverageStrategy(beverageType);
        beverage = strategy.make();
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
