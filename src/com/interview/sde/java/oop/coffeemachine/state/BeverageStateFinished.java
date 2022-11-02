package com.interview.sde.java.oop.coffeemachine.state;

public class BeverageStateFinished implements IBeverageState {

    @Override
    public IBeverageState transitionState(final BeverageState state) {
        switch (state) {
            case INITIAL:
                return new BeverageStateInitial();
            default:
                return new BeverageStateError();
        }
    }
}
