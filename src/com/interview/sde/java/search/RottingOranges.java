package com.interview.sde.java.search;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        final int TARGET = 1;
        final int AVOID = 2;

        Queue<int[]> oranges = new LinkedList<>();
        int freshOranges = 0;
        int maxDistance = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == TARGET) {
                    freshOranges++;
                } else if (grid[i][j] == AVOID) {
                    oranges.offer(new int[]{i, j});
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        while (!oranges.isEmpty()) {
            int toProcess = oranges.size();

            while (toProcess-- > 0) {

                int[] cell = oranges.poll();
                int row = cell[0];
                int column = cell[1];

                int topRow = row - 1;
                int rightColumn = column + 1;
                int bottomRow = row + 1;
                int leftColumn = column - 1;

                //top
                if (topRow >= 0 && grid[topRow][column] == TARGET) {
                    grid[topRow][column] = AVOID;
                    oranges.add(new int[]{topRow, column});
                }

                //right
                if (rightColumn <= grid[0].length - 1 && grid[row][rightColumn] == TARGET) {
                    grid[row][rightColumn] = AVOID;
                    oranges.add(new int[]{row, rightColumn});
                }

                //bottom
                if (bottomRow <= grid.length - 1 && grid[bottomRow][column] == TARGET) {
                    grid[bottomRow][column] = AVOID;
                    oranges.add(new int[]{bottomRow, column});
                }

                //left
                if (leftColumn >= 0 && grid[row][leftColumn] == TARGET) {
                    grid[row][leftColumn] = AVOID;
                    oranges.add(new int[]{row, leftColumn});
                }

            }

            freshOranges -= oranges.size();
            maxDistance++;

        }


        return freshOranges > 0 ? -1 : maxDistance;

    }
}
