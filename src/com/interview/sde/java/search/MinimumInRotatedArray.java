package com.interview.sde.java.search;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumInRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        if(nums.length == 1 || nums[start] < nums[end]){
            return nums[start];
        }

        while(start <= end){
            int mid = start + (end - start) /2;

            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if(nums[mid] > nums[0]){
                start = mid +1;
            } else{
                end = mid -1;
            }
        }
        return -1;
    }
}
