package com.interview.sde.hackerrank.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int max = 0;
        final char target = '1';
        final char avoid = '0';


        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1) {
                    max++;

                    Queue<int[]> cellsToProcess = new LinkedList<>();

                    cellsToProcess.add(new int[]{r, c});

                    while (!cellsToProcess.isEmpty()) {
                        int[] cell = cellsToProcess.poll();
                        int row = cell[0];
                        int column = cell[1];

                        int topRow = row - 1;
                        int rightColumn = column + 1;
                        int bottomRow = row + 1;
                        int leftColumn = column - 1;

                        //top
                        if (topRow >= 0 && grid[topRow][column] == target) {
                            grid[topRow][column] = avoid;
                            cellsToProcess.add(new int[]{topRow, column});
                        }

                        //right
                        if (rightColumn <= grid[0].length - 1 && grid[row][rightColumn] == target) {
                            grid[row][rightColumn] = avoid;
                            cellsToProcess.add(new int[]{row, rightColumn});
                        }

                        //bottom
                        if (bottomRow <= grid.length - 1 && grid[bottomRow][column] == target) {
                            grid[bottomRow][column] = avoid;
                            cellsToProcess.add(new int[]{bottomRow, column});
                        }

                        //left
                        if (leftColumn >= 0 && grid[row][leftColumn] == target) {
                            grid[row][leftColumn] = avoid;
                            cellsToProcess.add(new int[]{row, leftColumn});
                        }

                    }
                }

            }
        }
        return max;
    }
}
