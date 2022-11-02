package com.interview.sde.java.array;

//https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareSortedArray {
    public int[] sortedSquares(int[] nums) {

        //if contains positive, find its index
        int positiveIndex = -1;
        if (nums[0] >= 0 || nums[nums.length - 1] >= 0) {
            for (int i = 0; i < nums.length && positiveIndex == -1; i++) {
                if (nums[i] >= 0) {
                    positiveIndex = i;
                }
            }
        }

        //if contains negative, it will start before the positive
        int negativeIndex = positiveIndex > 0 ? positiveIndex - 1 : nums.length - 1;

        // while not processed all numbers
        // if not processed all negatives and negative number is smaller, square it and put on solution
        // else positive number is smaller, square it and put on solution
        // return solution
        int[] orderedSquareSolution = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int numValue = (negativeIndex >= 0 && (positiveIndex == nums.length || positiveIndex == -1 || Math.abs(nums[negativeIndex]) < Math.abs(nums[positiveIndex])))
                    ? nums[negativeIndex--]
                    : nums[positiveIndex++];
            orderedSquareSolution[i] = numValue * numValue;
        }

        return orderedSquareSolution;
    }
}
