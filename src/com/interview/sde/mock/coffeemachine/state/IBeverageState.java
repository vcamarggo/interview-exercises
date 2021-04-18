package com.interview.sde.mock.coffeemachine.state;

public interface IBeverageState {

     IBeverageState transitionState(final BeverageState state);
}
