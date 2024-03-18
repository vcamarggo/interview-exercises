package com.interview.sde.java.oop.coffeemachine.state;


class BeverageStateInitial implements IBeverageState {

    public IBeverageState transitionState(final BeverageState state) {
        return switch (state) {
            case PREPARING -> new BeverageStatePreparing();
            case CANCELED -> new BeverageStateCanceled();
            default -> new BeverageStateError();
        };
    }

}
