package com.interview.sde.java.sorting;

//https://leetcode.com/problems/sort-colors
public class InsertionSort {
    public void sortColors(int[] nums) {
        insertionSort(nums);
    }

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int inserting = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > inserting) {
                swap(nums, j + 1, j);
                j--;
            }
            nums[j + 1] = inserting;
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
