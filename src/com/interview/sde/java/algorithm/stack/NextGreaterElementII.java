package com.interview.sde.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII {
    static int[] nextGreaterElements(int[] nums) {

        Deque<Integer> stack = new LinkedList<>();
        //build reverse list of nums, it's necessary because the last element might not be the max
        for (int num : nums) {
            stack.offerLast(num);
        }

        //scan right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            final int curr = nums[i];
            //search to any right element bigger than current
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            //if stack is empty, there is no higher element, set -1
            //else, the higher element broke the previous while, and we assign it
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            //always push the current as it could be the higher than some element at the left
            stack.push(curr);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }
}
