package com.interview.sde.algorithm.dynamicprogramming;

import java.util.List;

//https://leetcode.com/problems/triangle/
public class Triangle {

    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal(List.of(List.of(-1), List.of(-2, -3))));
        System.out.println(new Triangle().minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(new Triangle().minimumTotal(List.of(List.of(-10))));
    }

    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size()];
        return minimumTotal(triangle, 0, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle, int lineIdx, int idx) {
        if (dp[lineIdx][idx] == null) {
            int sum = triangle.get(lineIdx).get(idx);

            //if is not last line, do the recursion
            if (lineIdx < triangle.size() - 1) {
                sum += Math.min(minimumTotal(triangle, lineIdx + 1, idx), minimumTotal(triangle, lineIdx + 1, idx + 1));
            }

            dp[lineIdx][idx] = sum;
        }
        return dp[lineIdx][idx];
    }
}
