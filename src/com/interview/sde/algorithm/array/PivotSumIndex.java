package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/find-pivot-index/
//https://leetcode.com/problems/find-the-middle-index-in-array/
public class PivotSumIndex {
    public int pivotIndex(int[] nums) {
        int[] right = new int[nums.length + 1];


        for (int i = 1, j = nums.length; i <= nums.length; i++, j--) {
            right[i] = nums[j - 1] + right[i - 1];
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left += nums[i - 1];
            }

            if (left == right[nums.length - 1 - i]) {
                return i;
            }
        }

        return -1;
    }
}
