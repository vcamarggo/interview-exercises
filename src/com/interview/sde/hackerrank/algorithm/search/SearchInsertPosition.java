package com.interview.sde.hackerrank.algorithm.search;

import java.util.Arrays;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int where = Arrays.binarySearch(nums, target);
        if(where >= 0 && nums[where] == target){
            return where;
        } else{
            where = Math.abs(where) - 1;
        }
        return where;
    }
}
