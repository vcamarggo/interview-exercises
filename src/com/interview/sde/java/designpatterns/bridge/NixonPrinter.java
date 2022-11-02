package com.interview.sde.designpatterns.bridge;

import java.util.Arrays;

public class NixonPrinter extends Printer {
    NixonPrinter(ColorScheme colorScheme) {
        super(colorScheme);
    }

    @Override
    void print() {
        System.out.println("Nixon printing with color schema" + Arrays.toString(colorScheme.getColorScheme()));
    }
}
