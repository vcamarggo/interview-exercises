package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/max-area-of-island/
public class MaximumAreaOfIslands {
    static int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        final int TARGET = 1;
        final int AVOID = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1) {
                    int islandSize = 0;

                    grid[r][c] = AVOID;
                    Queue<int[]> cellsToProcess = new LinkedList<>();

                    cellsToProcess.add(new int[]{r, c});

                    while (!cellsToProcess.isEmpty()) {
                        islandSize++;
                        int[] cell = cellsToProcess.poll();
                        int row = cell[0];
                        int column = cell[1];

                        int topRow = row - 1;
                        int rightColumn = column + 1;
                        int bottomRow = row + 1;
                        int leftColumn = column - 1;

                        //top
                        if (topRow >= 0 && grid[topRow][column] == TARGET) {
                            grid[topRow][column] = AVOID;
                            cellsToProcess.add(new int[]{topRow, column});
                        }

                        //right
                        if (rightColumn <= grid[0].length - 1 && grid[row][rightColumn] == TARGET) {
                            grid[row][rightColumn] = AVOID;
                            cellsToProcess.add(new int[]{row, rightColumn});
                        }

                        //bottom
                        if (bottomRow <= grid.length - 1 && grid[bottomRow][column] == TARGET) {
                            grid[bottomRow][column] = AVOID;
                            cellsToProcess.add(new int[]{bottomRow, column});
                        }

                        //left
                        if (leftColumn >= 0 && grid[row][leftColumn] == TARGET) {
                            grid[row][leftColumn] = AVOID;
                            cellsToProcess.add(new int[]{row, leftColumn});
                        }

                    }

                    max = Math.max(islandSize, max);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
//              new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
//              new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0},
//                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
//                new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }
}
