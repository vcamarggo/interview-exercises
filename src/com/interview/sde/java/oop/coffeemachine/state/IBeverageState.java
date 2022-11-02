package com.interview.sde.java.oop.coffeemachine.state;

public interface IBeverageState {

    IBeverageState transitionState(final BeverageState state);
}
