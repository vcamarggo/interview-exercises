package com.interview.sde.java.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/largest-number/
public class LargestNumber {

    static String largestNumber(int[] nums) {
        String result = IntStream
                .of(nums)
                .boxed()
                .sorted((a, b) -> (b.toString() + a).compareTo(a.toString() + b))
                .map(Object::toString)
                .collect(Collectors.joining())
                .replaceAll("\\D", "");
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
