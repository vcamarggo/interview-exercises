package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/majority-element
public class MajorityElement {

    //Boyer-Moore Voting Algorithm as on LeetCode solution
    public int majorityElement(int[] nums) {

        int majorityNumber = nums[0]; //Assuming one element exist, constraint from the original problem

        int majorityCounter = 0;

        for (int num : nums) {
            if (majorityCounter == 0) {
                majorityNumber = num;
            }
            majorityCounter += (num == majorityNumber) ? 1 : -1;
        }

        return majorityNumber;

    }
}
