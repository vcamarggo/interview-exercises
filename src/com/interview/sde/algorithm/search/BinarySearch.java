package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(final int[] nums, final int target, final int start, final int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            return (nums[mid] < target) ? search(nums, target, mid + 1, end) : search(nums, target, start, mid - 1);
        }
        return -1;
    }
}
