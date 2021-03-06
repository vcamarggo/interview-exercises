package com.interview.sde.algorithm.search;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindRangeOfK {

    static int[] searchRange(int[] nums, int target) {
        int[] solution = new int[2];
        solution[0] = binarySearch(nums, target, true, 0);

        //First find the leftmost target, then start from that position, as the rightmost will be at right of the leftmost
        solution[1] = binarySearch(nums, target, false, solution[0]);
        return solution;
    }

    static int binarySearch(int[] nums, int target, boolean searchLeft, int init) {
        return binarySearch(nums, target, searchLeft, Math.max(0, init), nums.length - 1);
    }

    static int binarySearch(int[] nums, int target, boolean searchLeft, int init, int end) {
        if (end < init) {
            return -1;
        }
        int mid = (end + init) / 2;
        if (nums[mid] > target || (searchLeft && (mid - 1) >= 0 && nums[mid - 1] == target)) {
            return binarySearch(nums, target, searchLeft, init, mid - 1);
        } else if (nums[mid] < target || (!searchLeft && (mid + 1) <= nums.length - 1 && nums[mid + 1] == target)) {
            return binarySearch(nums, target, searchLeft, mid + 1, end);
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); //3,4
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 10}, 8)));  // 3,3
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 10}, 8))); //-1,-1
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8}, 8))); //3,5
        System.out.println(Arrays.toString(searchRange(new int[]{8, 8, 8, 8, 8, 8}, 8))); //0,5
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6))); //-1,-1
        System.out.println(Arrays.toString(searchRange(new int[]{}, 8))); //-1,-1
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 8))); //-1,-1
    }
}
