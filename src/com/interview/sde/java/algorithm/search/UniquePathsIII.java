package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/unique-paths-iii/
public class UniquePathsIII {
    static int ROWS;
    static int COLUMNS;

    static int uniquePathsIII(int[][] obstacleGrid) {
        ROWS = obstacleGrid.length;
        COLUMNS = obstacleGrid[0].length;
        int[][] solution = new int[ROWS][COLUMNS];

        int startRow = 0;
        int startColumn = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (obstacleGrid[i][j] == 1) {
                    startRow = i;
                    startColumn = j;
                    solution[i][j] = -1;
                } else {
                    solution[i][j] = obstacleGrid[i][j];
                }
            }
        }

        return sumPaths(obstacleGrid, startRow, startColumn, solution);
    }

    static int sumPaths(int[][] obstacleGrid, int row, int column, int[][] solution) {

        if (obstacleGrid[row][column] == 2) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    if (solution[i][j] == 0) {
                        return 0;
                    }
                }
            }
            return 1;
        }

        return sumPathsNeighbor(obstacleGrid, row + 1, column, solution)
                + sumPathsNeighbor(obstacleGrid, row - 1, column, solution)
                + sumPathsNeighbor(obstacleGrid, row, column + 1, solution)
                + sumPathsNeighbor(obstacleGrid, row, column - 1, solution);
    }

    private static int sumPathsNeighbor(int[][] obstacleGrid, int row, int column, int[][] solution) {
        int sum = 0;
        if (canWalk(solution, row, column)) {
            final int prev = solution[row][column];
            solution[row][column] = -1;
            sum += sumPaths(obstacleGrid, row, column, solution);
            solution[row][column] = prev;
        }
        return sum;
    }


    private static boolean canWalk(int[][] obstacleGrid, int row, int column) {
        return row >= 0 && row < obstacleGrid.length && column >= 0 && column < obstacleGrid[0].length && obstacleGrid[row][column] != -1;
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{new int[]{1, 0, 0, 0}, new int[]{0, 0, 0, 0}, new int[]{0, 0, 2, -1}}));
        System.out.println(uniquePathsIII(new int[][]{new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 2}}));
    }
}
