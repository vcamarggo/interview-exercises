package com.interview.sde.mock.coffeemachine.state;

public class BeverageStateCanceled implements IBeverageState {
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
