package com.interview.sde.java.oop.coffeemachine.state;

public class BeverageStateFinished implements IBeverageState {

    @Override
    public IBeverageState transitionState(final BeverageState state) {
        return switch (state) {
            case INITIAL -> new BeverageStateInitial();
            default -> new BeverageStateError();
        };
    }
}
