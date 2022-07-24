package com.interview.sde.algorithm.dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{new int[]{2, 1, 3}, new int[]{6, 5, 4}, new int[]{7, 8, 9}}));
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{new int[]{-19, 57}, new int[]{-40, -5}}));
    }

    private Integer[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        memo = new Integer[matrix.length][matrix.length];
        for (int column = 0; column < matrix.length; column++) {
            minFallingPathSum(matrix, 0, column);
        }
        return Arrays.stream(memo[0]).min(Integer::compareTo).get();
    }

    public int minFallingPathSum(int[][] matrix, int row, int column) {
        if (row < matrix.length) {
            if (memo[row][column] == null) {
                if (column == 0) {
                    memo[row][column] = matrix[row][column] + Math.min(minFallingPathSum(matrix, row + 1, column), minFallingPathSum(matrix, row + 1, column + 1));
                } else if (column == matrix.length - 1) {
                    memo[row][column] = matrix[row][column] + Math.min(minFallingPathSum(matrix, row + 1, column - 1), minFallingPathSum(matrix, row + 1, column));
                } else {
                    memo[row][column] = matrix[row][column] + Math.min(minFallingPathSum(matrix, row + 1, column - 1), Math.min(minFallingPathSum(matrix, row + 1, column), minFallingPathSum(matrix, row + 1, column + 1)));
                }
            }
            return memo[row][column];
        }
        return 0;
    }

}
