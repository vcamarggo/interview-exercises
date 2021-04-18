package com.interview.sde.mock.coffeemachine.beverage.maker.strategy;

import com.interview.sde.mock.coffeemachine.beverage.Beverage;
import com.interview.sde.mock.coffeemachine.beverage.Cappuccino;

class MakeCappucino implements IBeveragePreparationStrategy {
    public Beverage make(){
        return new Cappuccino();
    }
}
