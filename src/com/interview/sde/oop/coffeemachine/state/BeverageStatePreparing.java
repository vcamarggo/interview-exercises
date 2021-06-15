package com.interview.sde.oop.coffeemachine.state;

class BeverageStatePreparing implements IBeverageState {

    public IBeverageState transitionState(final BeverageState state) {
        switch (state) {
            case FINISHED:
                return new BeverageStateFinished();
            case CANCELED:
                return new BeverageStateCanceled();
            default:
                return new BeverageStateError();
        }
    }
}
