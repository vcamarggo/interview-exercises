package com.interview.sde.oop.coffeemachine.beverage.maker;

import com.interview.sde.oop.coffeemachine.beverage.Beverage;
import com.interview.sde.oop.coffeemachine.beverage.maker.strategy.IBeveragePreparationStrategy;

class Machine implements IBeverageMaker {
    IBeveragePreparationStrategy strategy;

    Beverage beverage;

    Machine(final BeverageType  beverageType) {
        //A Factory can be implemented here
        this.strategy = null; // Factory.getBeverageStrategy(beverageType);
    }

    public void makeBeverage() {
        beverage = strategy.make();
    }

    public Beverage getBeverage() {
        return beverage;
    }
}
