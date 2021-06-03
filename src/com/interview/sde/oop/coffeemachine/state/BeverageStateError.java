package com.interview.sde.oop.coffeemachine.state;

public class BeverageStateError implements IBeverageState {
    @Override
    public IBeverageState transitionState(final BeverageState state) {
        throw new RuntimeException("Error in system integrity");
    }
}
