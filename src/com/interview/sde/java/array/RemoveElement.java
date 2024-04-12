package com.interview.sde.java.array;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int removedValCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                removedValCount++;
                int j = i;
                while (j > 0 && nums[j - 1] == val) {
                    nums[j - 1] = nums[j];
                    nums[j] = val;
                    j--;
                }
            }
        }

        return removedValCount;
    }
}
