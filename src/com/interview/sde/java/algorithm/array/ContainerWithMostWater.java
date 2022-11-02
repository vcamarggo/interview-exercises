package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max = calculateArea(height, left, right);

        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, calculateArea(height, left, right));
        }
        return max;
    }

    private int calculateArea(int[] height, int left, int right) {
        //area is equals the distance between left and right multiplied by the smaller container wall
        return Math.min(height[left], height[right]) * (right - left);
    }
}
