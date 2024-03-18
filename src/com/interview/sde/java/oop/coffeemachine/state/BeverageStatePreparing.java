package com.interview.sde.java.oop.coffeemachine.state;

class BeverageStatePreparing implements IBeverageState {

    public IBeverageState transitionState(final BeverageState state) {
        return switch (state) {
            case FINISHED -> new BeverageStateFinished();
            case CANCELED -> new BeverageStateCanceled();
            default -> new BeverageStateError();
        };
    }
}
