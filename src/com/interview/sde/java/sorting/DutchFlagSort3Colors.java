package com.interview.sde.java.sorting;

//https://leetcode.com/problems/sort-colors/
public class DutchFlagSort3Colors {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && red < i) {
                swap(nums, red++, i--);
            } else if (nums[i] == 2 && blue > i) {
                swap(nums, blue--, i--);
            }
        }
    }

    public void swap(int[] nums, int from, int to) {
        int tmp = nums[to];
        nums[to] = nums[from];
        nums[from] = tmp;
    }
}
