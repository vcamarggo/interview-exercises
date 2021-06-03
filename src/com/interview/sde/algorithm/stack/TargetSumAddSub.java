package com.interview.sde.algorithm.stack;

//https://leetcode.com/problems/target-sum/
public class TargetSumAddSub {

    static int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[nums.length][2001];
        return findTargetSumWays(nums, target, 0, 0);
//        return findTargetSumWaysMemo(nums, target, 0, 0, memo);
    }

    static int findTargetSumWays(int[] nums, int target, int sum, int startIndex) {
        if (startIndex == nums.length) {
            return sum == target ? 1 : 0;
        }
        return findTargetSumWays(nums, target, sum + nums[startIndex], startIndex + 1) + findTargetSumWays(nums, target, sum - nums[startIndex], startIndex + 1);
    }

    //Memoized version made the code twice as slower on leetcode
    static int findTargetSumWaysMemo(int[] nums, int target, int sum, int startIndex, int[][] memo) {
        if (startIndex == nums.length) {
            return sum == target ? 1 : 0;
        }
        int add = findTargetSumWaysMemo(nums, target, sum + nums[startIndex], startIndex + 1, memo);
        int sub = findTargetSumWaysMemo(nums, target, sum - nums[startIndex], startIndex + 1, memo);
        memo[startIndex][sum + 1000] = add + sub;
        return memo[startIndex][sum + 1000];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
