package com.interview.sde.java.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSort(new int[]{-2, 0, 2, 1, 1, 0})));
    }

    public static int[] countSort(int[] nums) {

        if (isNullOrEmpty(nums)) {
            return nums;
        }

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        final int[] buckets = countNumOccurrenceNumbers(nums, min, max);

        return orderNumsBasedOnBuckets(min, nums, buckets);
    }

    private static boolean isNullOrEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    private static int[] countNumOccurrenceNumbers(int[] nums, int min, int max) {
        int[] buckets = createBucketsFromMinToMax(min, max);

        for (int num : nums) {
            buckets[num - min] += 1;
        }

        return buckets;
    }

    private static int[] createBucketsFromMinToMax(final int min, final int max) {
        return new int[max - min + 1];
    }

    private static int[] orderNumsBasedOnBuckets(int min, int[] nums, int[] buckets) {
        int lastFilledNumIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                nums[lastFilledNumIndex++] = i + min;
                buckets[i]--;
            }
        }
        return nums;
    }

}
