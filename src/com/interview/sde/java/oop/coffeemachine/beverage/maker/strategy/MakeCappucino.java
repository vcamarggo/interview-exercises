package com.interview.sde.java.oop.coffeemachine.beverage.maker.strategy;

import com.interview.sde.java.oop.coffeemachine.beverage.Beverage;
import com.interview.sde.java.oop.coffeemachine.beverage.Cappuccino;

class MakeCappucino implements IBeveragePreparationStrategy {
    public Beverage make() {
        return new Cappuccino();
    }
}
