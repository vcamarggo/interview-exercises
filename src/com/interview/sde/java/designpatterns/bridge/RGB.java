package com.interview.sde.designpatterns.bridge;

public class RGB implements ColorScheme {
    @Override
    public int[] getColorScheme() {
        return new int[]{255, 255, 255};
    }
}
