package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public int trap(int[] height) {
        int water = 0;
        int lMaxGlobal = 0;
        int[] rMaxGlobal = new int[height.length];

        rMaxGlobal[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMaxGlobal[i] = Math.max(height[i], rMaxGlobal[i + 1]);
        }

        for (int i = 1; i < height.length; i++) {
            int lMax = height[i];
            int rMax = height[i];

            lMaxGlobal = Math.max(lMaxGlobal, height[i - 1]);
            lMax = Math.max(lMax, lMaxGlobal);

            rMax = Math.max(rMax, rMaxGlobal[i]);

            water += Math.min(lMax, rMax) - height[i];
        }

        return water;
    }
}
