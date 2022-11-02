package com.interview.sde.algorithm.sorting;

import java.util.*;

public class RadixSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(radixSort(new int[]{-2, 0, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(radixSort(new int[]{170, 45, 75, 90, 802, 24, 2, 66})));
        System.out.println(Arrays.toString(radixSort(new int[]{-2345, -7, 1})));
    }

    public static int[] radixSort(int[] nums) {

        if (isNullOrEmpty(nums)) {
            return nums;
        }

        int max = getMaxAbs(nums);
        int digitPosition = 1;

        while (hasNextDigit(max)) {
            nums = partialSortElements(digitPosition, nums);

            max = getNextDigit(max);
            digitPosition = getNextDigitPosition(digitPosition);
        }

        return nums;
    }

    private static boolean isNullOrEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    private static int getMaxAbs(int[] nums) {
        return Arrays.stream(nums).map(Math::abs).max().getAsInt();
    }

    private static boolean hasNextDigit(final int max) {
        return max != 0;
    }

    private static int[] partialSortElements(int digitPosition, int[] nums) {
        Map<Integer, List<Integer>> buckets = fillBuckets(digitPosition, nums);
        return moveBucketsToArray(buckets, nums.length);
    }

    private static Map<Integer, List<Integer>> fillBuckets(int digitPosition, int[] nums) {
        Map<Integer, List<Integer>> buckets = new TreeMap<>();
        for (int num : nums) {
            int key = getNumberAtDigitPosition(digitPosition, num);
            buckets.computeIfAbsent(key, k-> new ArrayList<>()).add(num);
        }
        return buckets;
    }

    private static int getNumberAtDigitPosition(int digitPosition, int num) {
        return (num / digitPosition) % 10;
    }

    private static int[] moveBucketsToArray(Map<Integer, List<Integer>> buckets, int numsSize) {
        int[] nums = new int[numsSize];
        int lastFilledNumIndex = 0;

        for (List<Integer> bucketValue : buckets.values()) {
            for (Integer number : bucketValue) {
                nums[lastFilledNumIndex++] = number;
            }
        }
        return nums;
    }

    private static int getNextDigit(final int max) {
        return max / 10;
    }

    private static int getNextDigitPosition(int digitPosition) {
        return digitPosition * 10;
    }

}
