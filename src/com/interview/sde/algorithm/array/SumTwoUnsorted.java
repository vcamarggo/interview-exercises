package com.interview.sde.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class SumTwoUnsorted {

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sums = new HashMap<>(nums.length);

        for (int index = 0; index < nums.length; index++) {
            int newTarget = target - nums[index];
            if (sums.containsKey(newTarget)) {
                return new int[]{sums.get(newTarget), index};
            }
            sums.put(nums[index], index);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{0, 0, 3, 4}, 0)));
    }
}
