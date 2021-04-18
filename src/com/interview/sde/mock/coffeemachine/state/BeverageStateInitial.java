package com.interview.sde.mock.coffeemachine.state;


class BeverageStateInitial implements IBeverageState {

    public IBeverageState transitionState(final BeverageState state) {
        switch (state) {
            case PREPARING:
                return new BeverageStatePreparing();
            case CANCELED:
                return new BeverageStateCanceled();
            default:
                return new BeverageStateError();
        }
    }

}
