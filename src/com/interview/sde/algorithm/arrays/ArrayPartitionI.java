package com.interview.sde.algorithm.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/array-partition-i/
public class ArrayPartitionI {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        return IntStream.range(0, nums.length).filter(i -> i % 2 == 0).mapToObj(i -> nums[i]).reduce(Integer::sum).get();
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
