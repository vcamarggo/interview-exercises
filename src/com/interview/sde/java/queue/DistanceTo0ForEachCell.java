package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
public class DistanceTo0ForEachCell {
    static int[][] updateMatrix(int[][] grid) {
        int[][] gridTo0 = new int[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                gridTo0[r][c] = calculateDistanceToZero(grid, r, c);
            }
        }
        return gridTo0;
    }

    private static int calculateDistanceToZero(int[][] grid, int r, int c) {
        final int TARGET = 0;

        if (grid[r][c] != TARGET) {
            Queue<int[]> cellsToProcess = new LinkedList<>();
            cellsToProcess.add(new int[]{r, c});
            int level = 0;

            while (!cellsToProcess.isEmpty()) {
                int remaining = cellsToProcess.size();
                while (remaining-- > 0) {
                    int[] cell = cellsToProcess.poll();
                    int row = cell[0];
                    int column = cell[1];

                    int topRow = row - 1;
                    int rightColumn = column + 1;
                    int bottomRow = row + 1;
                    int leftColumn = column - 1;

                    //Short circuit if found the solution before adding to queue makes it up to 3.1 times faster
                    // I'm opting for readability in this case
                    if (grid[row][column] == TARGET) {
                        return level;
                    }

                    //top
                    if (topRow >= 0) {
                        cellsToProcess.add(new int[]{topRow, column});
                    }

                    //right
                    if (rightColumn <= grid[0].length - 1) {
                        cellsToProcess.add(new int[]{row, rightColumn});
                    }

                    //bottom
                    if (bottomRow <= grid.length - 1) {
                        cellsToProcess.add(new int[]{bottomRow, column});
                    }

                    //left
                    if (leftColumn >= 0) {
                        cellsToProcess.add(new int[]{row, leftColumn});
                    }
                }
                level += 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        updateMatrix(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}});
    }

}

