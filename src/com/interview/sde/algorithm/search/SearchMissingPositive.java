package com.interview.sde.algorithm.search;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//Based on Leetcode problem, but does not solve with O(1) space
//https://leetcode.com/problems/first-missing-positive/
public class SearchMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> added = Arrays.stream(nums).boxed().filter(i -> i > 0).collect(Collectors.toSet());

        for (int i = 1; i <= nums.length; i++) {
            if (!added.contains(i)) {
                return i;
            }
        }
        return nums.length+1;
    }

}
