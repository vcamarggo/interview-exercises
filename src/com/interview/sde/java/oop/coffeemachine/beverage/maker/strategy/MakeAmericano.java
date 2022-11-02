package com.interview.sde.java.oop.coffeemachine.beverage.maker.strategy;

import com.interview.sde.java.oop.coffeemachine.beverage.Americano;
import com.interview.sde.java.oop.coffeemachine.beverage.Beverage;

class MakeAmericano implements IBeveragePreparationStrategy {
    public Beverage make() {
        return new Americano();
    }
}
