package com.interview.sde.java.array;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumWindow {
    static int maxSubArray(int[] nums) {
        int max = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            max = Math.max(prev, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
