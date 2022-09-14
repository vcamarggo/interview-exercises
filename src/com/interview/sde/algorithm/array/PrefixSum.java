package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/range-sum-query-immutable/
public class PrefixSum {

    int[] sum;

    public PrefixSum(int[] nums) {
        this.sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            this.sum[i] = this.sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
