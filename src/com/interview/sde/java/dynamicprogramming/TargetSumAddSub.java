package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/target-sum/
public class TargetSumAddSub {

    static final int SUM_UPPER_BOUNDARY = 1000;

    static int findTargetSumWays(int[] nums, int target) {
        Integer[][] memo = new Integer[nums.length + 1][2 * SUM_UPPER_BOUNDARY + 1];
//        return findTargetSumWays(nums, target, 0, 0);
        return findTargetSumWaysMemo(nums, target, 0, 0, memo);
    }

    //Brute-force
    static int findTargetSumWays(int[] nums, int target, int sum, int startIndex) {
        if (startIndex == nums.length) {
            return sum == target ? 1 : 0;
        }
        return findTargetSumWays(nums, target, sum + nums[startIndex], startIndex + 1) + findTargetSumWays(nums, target, sum - nums[startIndex], startIndex + 1);
    }

    //Memoized version
    static int findTargetSumWaysMemo(int[] nums, int target, int sum, int startIndex, Integer[][] memo) {
        if (memo[startIndex][sum + SUM_UPPER_BOUNDARY] != null) {
            return memo[startIndex][sum + SUM_UPPER_BOUNDARY];
        }

        if (startIndex == nums.length) {
            return sum == target ? 1 : 0;
        }
        int add = findTargetSumWaysMemo(nums, target, sum + nums[startIndex], startIndex + 1, memo);
        int sub = findTargetSumWaysMemo(nums, target, sum - nums[startIndex], startIndex + 1, memo);
        return memo[startIndex][sum + SUM_UPPER_BOUNDARY] = add + sub;
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
