package com.interview.sde.oop.coffeemachine.state;

public interface IBeverageState {

    IBeverageState transitionState(final BeverageState state);
}
