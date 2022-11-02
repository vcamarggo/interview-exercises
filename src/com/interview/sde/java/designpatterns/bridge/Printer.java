package com.interview.sde.java.designpatterns.bridge;

public abstract class Printer {
    final ColorScheme colorScheme;

    Printer(ColorScheme colorScheme) {
        this.colorScheme = colorScheme;
    }

    abstract void print();
}
