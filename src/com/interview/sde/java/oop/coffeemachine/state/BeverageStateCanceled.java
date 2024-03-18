package com.interview.sde.java.oop.coffeemachine.state;

public class BeverageStateCanceled implements IBeverageState {
    @Override
    public IBeverageState transitionState(final BeverageState state) {
        return switch (state) {
            case INITIAL -> new BeverageStateInitial();
            default -> new BeverageStateError();
        };
    }
}
