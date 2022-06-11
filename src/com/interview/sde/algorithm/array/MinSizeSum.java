package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinSizeSum {

    int minSubArrayLen(int target, int[] nums) {
        int sum = 0;

        int minSize = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        //Sliding window implementation
        //If did not fully slide left-to-right
        while (left < nums.length) {

            //If right is at the end or sum is gte target, slide window left-to-right
            if (right == nums.length || sum >= target) {
                sum -= nums[left];
                left++;
            } else { //Slide window right-to-right
                sum += nums[right];
                right++;
            }

            if (sum >= target) {
                minSize = Math.min(minSize, right - left);
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
