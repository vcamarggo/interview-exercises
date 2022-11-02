package com.interview.sde.algorithm.array;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {

    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int current = 1; current < nums.length; current++) {
            // Move to right multiplying the previous elements, but skipping current
            // result act as an aggregator array
            final int previous = current - 1;
            result[current] = result[previous] * nums[previous];
        }

        int multiplierAgg = 1;
        for (int current = nums.length - 2; current >= 0; current--) {
            // Move to left multiplying the elements, multiplierAgg act as multiplication aggregator
            // There is no need for the full aggregator array as the output is being built on result array
            final int next = current + 1;
            multiplierAgg *= nums[next];
            result[current] *= multiplierAgg;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
