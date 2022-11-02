package com.interview.sde.java.oop.coffeemachine.state;

//Adding beverage info would make easier to move between states
public enum BeverageState {
    INITIAL, PREPARING, CANCELED, FINISHED
}
