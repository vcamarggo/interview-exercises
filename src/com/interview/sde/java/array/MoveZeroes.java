package com.interview.sde.java.array;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        while (lastNonZeroIndex < nums.length) {
            nums[lastNonZeroIndex++] = 0;
        }
    }
}
