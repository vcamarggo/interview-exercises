package com.interview.sde.oop.coffeemachine.beverage.maker.strategy;

import com.interview.sde.oop.coffeemachine.beverage.Americano;
import com.interview.sde.oop.coffeemachine.beverage.Beverage;

class MakeAmericano implements IBeveragePreparationStrategy {
    public Beverage make() {
        return new Americano();
    }
}
