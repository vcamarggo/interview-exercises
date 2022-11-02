package com.interview.sde.java.string;

import java.util.Arrays;
import java.util.stream.IntStream;

//https://leetcode.com/problems/largest-number/
public class LargestNumber {

    static String largestNumber(int[] nums) {
        Integer[] numbers = IntStream.of(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numbers, (Integer a, Integer b) -> (b.toString() + a).compareTo(a.toString() + b));
        String result = Arrays.toString(numbers).replaceAll("\\D", "");
        return result.charAt(0) == '0' ? "0" : result;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0, 0}));
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{2, 10}));
        System.out.println(largestNumber(new int[]{432, 43243}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{111311, 1113}));
    }
}
