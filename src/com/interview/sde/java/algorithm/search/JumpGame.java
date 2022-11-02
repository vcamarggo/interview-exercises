package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/jump-game
public class JumpGame {
    private static Boolean[] memo;

    public static void main(String[] args) {
        System.out.println(canJumpDp(new int[]{3, 2, 1, 0, 4})); //false
        System.out.println(canJumpDp(new int[]{3, 2, 1, 1, 4})); //true
        System.out.println(canJumpDp(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0})); //true
        System.out.println(canJumpDp(new int[]{3, 2, 12, 0, 4})); //true
        System.out.println(canJumpDp(new int[]{3, 2, 12, 0, 0})); //true
        System.out.println(canJumpDp(new int[]{3, 0, 0, 0, 0})); //false
        System.out.println(canJumpDp(new int[]{4, 0, 0, 0, 0})); //true
        System.out.println(canJumpDp(new int[]{0})); //true
        System.out.println(canJumpDp(new int[]{1})); //true
        System.out.println(canJumpDp(new int[]{1, 0})); //true
    }

    static boolean canJumpDp(int[] nums) {
        memo = new Boolean[nums.length];
        return canJump(nums, 0);
    }

    static boolean canJump(int[] nums, int startIndex) {
        if (memo[startIndex] != null) return memo[startIndex];

        if (nums.length - 1 == startIndex) {
            memo[startIndex] = true;
            return memo[startIndex];
        }

        for (int i = 1; i <= nums[startIndex]; i++) {
            if (canJump(nums, startIndex + i)) {
                memo[startIndex + i] = true;
                return memo[startIndex + i];
            }
        }
        memo[startIndex] = false;
        return memo[startIndex];
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        return canJump(nums, nums.length - 1, -1);
    }

    boolean canJump(int[] nums, int start, int zeroIndex) {
        boolean possible = false;

        for (int i = start; i >= 0; i--) {
            if (nums[i] == 0 && !canJump(nums, i - 1, i)) {
                return false;
            }
            if (zeroIndex == -1 || nums[i] > zeroIndex - i || nums[i] >= zeroIndex - i && zeroIndex == nums.length - 1) {
                possible = true;
            }
        }
        return possible;
    }
}
