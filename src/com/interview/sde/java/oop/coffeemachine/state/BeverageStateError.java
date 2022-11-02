package com.interview.sde.java.oop.coffeemachine.state;

public class BeverageStateError implements IBeverageState {
    @Override
    public IBeverageState transitionState(final BeverageState state) {
        throw new RuntimeException("Error in system integrity");
    }
}
