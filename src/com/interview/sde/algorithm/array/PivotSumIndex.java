package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/find-pivot-index/
//https://leetcode.com/problems/find-the-middle-index-in-array/
public class PivotSumIndex {
    public int pivotIndex(int[] nums) {
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];


        for (int i = 1, j = nums.length; i <= nums.length; i++, j--) {
            left[i] = nums[i - 1] + left[i - 1];
            right[i] = nums[j - 1] + right[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[nums.length - 1 - i]) {
                return i;
            }
        }

        return -1;
    }
}
