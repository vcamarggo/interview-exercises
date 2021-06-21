package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/jump-game
public class JumpGame {
    static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        return canJump(nums, nums.length - 1, -1);
    }

    static boolean canJump(int[] nums, int start, int zeroIndex) {
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

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); //false
        System.out.println(canJump(new int[]{3, 2, 1, 1, 4})); //true
        System.out.println(canJump(new int[]{3, 2, 12, 0, 4})); //true
        System.out.println(canJump(new int[]{3, 2, 12, 0, 0})); //true
        System.out.println(canJump(new int[]{3, 0, 0, 0, 0})); //false
        System.out.println(canJump(new int[]{4, 0, 0, 0, 0})); //true
        System.out.println(canJump(new int[]{0})); //false
        System.out.println(canJump(new int[]{1})); //true
        System.out.println(canJump(new int[]{1, 0})); //true
    }
}
