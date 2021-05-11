package com.interview.sde.hackerrank.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures
public class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        int[] waitList = new int[temperatures.length];

        Stack<Integer> daily = new Stack<>();
        for (int i = 0; i < waitList.length; i++) {
            while (!daily.isEmpty() && temperatures[daily.peek()] < temperatures[i]) {
                waitList[daily.peek()] = i - daily.pop();
            }
            daily.push(i);
        }

        return waitList;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
