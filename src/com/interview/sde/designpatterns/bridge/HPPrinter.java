package com.interview.sde.designpatterns.bridge;

import java.util.Arrays;

public class HPPrinter extends Printer {

    HPPrinter(ColorScheme colorScheme) {
        super(colorScheme);
    }

    @Override
    public void print() {
        System.out.println("HP printing with color schema" + Arrays.toString(colorScheme.getColorScheme()));
    }
}
