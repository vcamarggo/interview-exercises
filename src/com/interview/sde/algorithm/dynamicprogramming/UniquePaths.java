package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/unique-paths
public class UniquePaths {
    static int uniquePaths(final int ROWS, final int COLUMNS) {
        int[][] solution = new int[ROWS][COLUMNS];

        for (int row = 0; row < ROWS; row++) {
            solution[row][0] = 1;
        }

        for (int column = 0; column < COLUMNS; column++) {
            solution[0][column] = 1;
        }

        for (int row = 1; row < ROWS; row++) {
            for (int column = 1; column < COLUMNS; column++) {
                solution[row][column] = solution[row - 1][column] + solution[row][column - 1];
            }
        }
        return solution[ROWS - 1][COLUMNS - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
}
