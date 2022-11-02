package com.interview.sde.java.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence
public class LongestIncreasingSubsequence {
    static int lengthOfLIS(int[] nums) {
        int[] longestI = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longestI[i] = 1;
            for (int j = 0; j < i; j++) {
                int longestJPath = 1 + longestI[j];
                if (nums[j] < nums[i] && longestI[i] < longestJPath) {
                    longestI[i] = longestJPath;
                }
            }
        }
        return Arrays.stream(longestI).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 2, 3, 4, 3}));
    }
}
