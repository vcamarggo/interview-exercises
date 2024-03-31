package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/minimum-falling-path-sum-ii
public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        Integer[][] memo = new Integer[grid.length][grid[0].length];

        int min = Integer.MAX_VALUE;
        int initRow = 0;

        for (int c = 0; c < grid[0].length; c++) {
            min = Math.min(min, minPath(memo, grid, initRow, c));
        }
        return min;
    }

    private int minPath(Integer[][] memo, int[][] grid, int initRow, int initColumn) {
        if (initRow == grid.length - 1) {
            return memo[initRow][initColumn] = grid[initRow][initColumn];
        }

        if (memo[initRow][initColumn] == null) {
            memo[initRow][initColumn] = calculateMin(memo, grid, initRow, initColumn);
        }
        return memo[initRow][initColumn];
    }

    private int calculateMin(Integer[][] memo, int[][] grid, int initRow, int initColumn) {
        int min = Integer.MAX_VALUE;
        for (int column = 0; column < grid[0].length; column++) {
            if (column != initColumn)
                min = Math.min(min, minPath(memo, grid, initRow + 1, column) + grid[initRow][initColumn]);
        }
        return min;
    }
}
