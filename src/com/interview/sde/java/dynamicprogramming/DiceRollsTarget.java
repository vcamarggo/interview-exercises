package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum
public class DiceRollsTarget {
    private final int MOD = 1000000007;
    private Integer[][] memo;

    public int numRollsToTarget(int dices, int faces, int target) {
        memo = new Integer[dices + 1][target + 1];
        return numRollsToTargetInternal(dices, faces, target);
    }

    public int numRollsToTargetInternal(int dices, int faces, int target) {
        if (dices == 0 && target == 0) return 1; // found solution
        if (dices == 0 || target <= 0) return 0; // impossible to find solution

        if (memo[dices][target] == null) {
            memo[dices][target] = 0;
            for (int i = 1; i <= faces; i++) {
                memo[dices][target] = (memo[dices][target] + numRollsToTargetInternal(dices - 1, faces, target - i)) % MOD;
            }
        }
        return memo[dices][target];
    }
}
