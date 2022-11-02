package com.interview.sde.algorithm.array;

import java.util.Arrays;
import java.util.Random;

//https://leetcode.com/problems/shuffle-an-array/
public class ShuffleArray {
    final int[] originalData;

    public ShuffleArray(int[] nums) {
        this.originalData = nums;
    }

    public int[] reset() {
        return originalData;
    }

    public int[] shuffle() {
        int[] array = Arrays.copyOf(originalData, originalData.length);

        //Generate a randomized list of nums and copy to end array
//        List<Integer> nums = IntStream.range(0,originalData.length).boxed().collect(Collectors.toList());
//        Collections.shuffle(nums);
//
//        for (int i = 0; i < nums.size(); i++) {
//            array[i] = originalData[nums.get(i)];
//        }

        Random generator = new Random();

        for (int i = 0; i < array.length; i++) {
            swap(array, i, generator.nextInt(array.length));
        }

        return array;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
