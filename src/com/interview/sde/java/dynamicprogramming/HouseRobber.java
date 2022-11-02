package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    private Integer[] memo;

    public int rob(int[] nums) {
        this.memo = new Integer[nums.length];
        return rob(nums, 0);
    }

    public int rob(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] == null) {
            memo[i] = Math.max(nums[i] + rob(nums, i + 2), rob(nums, i + 1));
        }
        return memo[i];
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
    }
}
