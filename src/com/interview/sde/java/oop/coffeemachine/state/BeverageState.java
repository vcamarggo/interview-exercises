package com.interview.sde.oop.coffeemachine.state;

//Adding beverage info would make easier to move between states
public enum BeverageState {
    INITIAL, PREPARING, CANCELED, FINISHED
}
