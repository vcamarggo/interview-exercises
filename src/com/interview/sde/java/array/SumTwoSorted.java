package com.interview.sde.java.array;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class SumTwoSorted {

    static int[] twoSum(int[] nums, int target) {
        for (int index1 = 0; index1 < nums.length; index1++) {
            int newTarget = target - nums[index1];
            int index2 = binarySearch(nums, newTarget, index1 + 1, nums.length - 1);
            if (index2 != -1) {
                //Index +1 was a challenge requirement
                return new int[]{index1 + 1, index2 + 1};
            }
        }
        return new int[]{};
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            return (nums[mid] < target) ? binarySearch(nums, target, mid + 1, end) : binarySearch(nums, target, start, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{0, 0, 3, 4}, 0)));
    }
}
