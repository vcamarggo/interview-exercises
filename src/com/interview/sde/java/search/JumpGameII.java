package com.interview.sde.java.search;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    public int jump(int[] nums) {
        return jump(nums, new int[nums.length], 0);
    }

    int jump(int[] nums, int[] memo, int startIndex) {
        if (memo[startIndex] == 0) {
            if (nums.length - 1 <= startIndex) {
                return 0;
            }

            int min = 100000;
            for (int i = 1; i <= nums[startIndex] && startIndex + i < nums.length; i++) {
                min = Math.min(min, jump(nums, memo, startIndex + i) + 1);
            }

            memo[startIndex] = min;
        }
        return memo[startIndex];
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7, 2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7, 7, 0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0}));
        System.out.println(new JumpGameII().jump(new int[]{9, 8, 2, 2, 0, 2, 2, 0, 4, 1, 5, 7, 9, 6, 6, 0, 6, 5, 0, 5}));
        System.out.println(new JumpGameII().jump(new int[]{1, 2, 0, 1}));
        System.out.println(new JumpGameII().jump(new int[]{2, 1}));
//        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
    }
}
