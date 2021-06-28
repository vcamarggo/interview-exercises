package com.interview.sde.algorithm.sorting;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesSortedArray {
    static int removeDuplicates(int[] nums) {
        int lastModifiedIndex = 0;
        int lastModifiedNumber = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > lastModifiedNumber){
                nums[lastModifiedIndex++] = nums[i];
                lastModifiedNumber = nums[i];
            }
        }

        return lastModifiedIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{}));
    }
}
