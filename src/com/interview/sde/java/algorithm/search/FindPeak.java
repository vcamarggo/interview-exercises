package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/find-peak-element
public class FindPeak {

    public int findPeakElement(int[] nums) {
        if (nums.length >= 2) {
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
            if (nums[0] > nums[1]) {
                return 0;
            }
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
