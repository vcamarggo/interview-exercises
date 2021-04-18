package com.interview.sde.mock.coffeemachine.beverage.maker.strategy;

import com.interview.sde.mock.coffeemachine.beverage.Americano;
import com.interview.sde.mock.coffeemachine.beverage.Beverage;

class MakeAmericano implements IBeveragePreparationStrategy {
    public Beverage make(){
        return new Americano();
    }
}
