package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int ROWS = obstacleGrid.length + 1;
        final int COLUMNS = obstacleGrid[0].length + 1;
        int[][] solution = new int[ROWS][COLUMNS];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int row = 1; row < ROWS; row++) {
            for (int column = 1; column < COLUMNS; column++) {
                if (row == 1 && column == 1) {
                    solution[row][column] = 1;
                } else if (obstacleGrid[row - 1][column - 1] == 1) {
                    solution[row][column] = 0;
                } else {
                    solution[row][column] = solution[row - 1][column] + solution[row][column - 1];
                }
            }
        }
        return solution[ROWS - 1][COLUMNS - 1];
    }
}
