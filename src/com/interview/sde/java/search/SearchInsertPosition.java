package com.interview.sde.java.search;

import java.util.Arrays;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int where = Arrays.binarySearch(nums, target);
        return (where >= 0 && nums[where] == target) ? where : Math.abs(where) - 1;
    }
}
