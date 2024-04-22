package com.interview.sde.java.greedy;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int units = 0;

        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int min = Math.min(boxTypes[i][0], truckSize);
            units += min * boxTypes[i][1];
            truckSize -= min;
        }
        return units;
    }
}
