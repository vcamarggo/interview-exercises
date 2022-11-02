package com.interview.sde.java.array;

//https://leetcode.com/problems/gas-station/
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasRemaining = 0;
        int missingGas = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGasRemaining += gas[i] - cost[i];
            if (totalGasRemaining < 0) {
                missingGas += totalGasRemaining;
                totalGasRemaining = 0;
                startIndex = i + 1;
            }
        }
        return totalGasRemaining + missingGas >= 0 ? startIndex : -1;
    }
}
