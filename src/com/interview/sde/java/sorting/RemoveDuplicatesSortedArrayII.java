package com.interview.sde.java.sorting;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class RemoveDuplicatesSortedArrayII {
    static int removeDuplicates(int[] nums) {
        int lastModifiedIndex = 0;
        int lastModifiedNumber = Integer.MIN_VALUE;
        int repeatedCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > lastModifiedNumber || nums[i] == lastModifiedNumber && repeatedCount < 1){
                if(nums[i] ==   lastModifiedNumber) {
                    repeatedCount++;
                } else {
                    repeatedCount = 0;
                }
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
