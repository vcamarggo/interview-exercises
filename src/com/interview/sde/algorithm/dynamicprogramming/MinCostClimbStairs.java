package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbStairs {
    Integer[] memo;

    public int minCostClimbingStairs(int[] cost) {
        memo = new Integer[cost.length];
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    public int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] == null) {
            memo[i] = Math.min(cost[i] + minCostClimbingStairs(cost, i + 1), cost[i] + minCostClimbingStairs(cost, i + 2));
        }
        return memo[i];
    }
}
