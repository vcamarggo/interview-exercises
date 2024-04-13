package com.interview.sde.java.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
public class MinimumObstacleRemovalReachCorner {
    public int minimumObstacles(int[][] grid) {
        int[][] nodesDistance = new int[grid.length][grid[0].length];
        for (int[] arr : nodesDistance) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> nodesToProcess = new PriorityQueue<>(Comparator.comparingInt(o -> nodesDistance[o[0]][o[1]]));

        nodesDistance[0][0] = grid[0][0];
        nodesToProcess.add(new int[]{0, 0});

        while (!nodesToProcess.isEmpty()) {
            int[] cell = nodesToProcess.poll();
            int row = cell[0];
            int column = cell[1];
            int distance = nodesDistance[row][column];

            int topRow = row - 1;
            int rightColumn = column + 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;

            if (row == grid.length - 1 && column == grid[0].length - 1) return distance;

            //top
            if (topRow >= 0 && distance + grid[topRow][column] < nodesDistance[topRow][column]) {
                nodesDistance[topRow][column] = distance + grid[topRow][column];
                nodesToProcess.add(new int[]{topRow, column});
            }

            //right
            if (rightColumn <= grid[0].length - 1 && distance + grid[row][rightColumn] < nodesDistance[row][rightColumn]) {
                nodesDistance[row][rightColumn] = distance + grid[row][rightColumn];
                nodesToProcess.add(new int[]{row, rightColumn});
            }

            //bottom
            if (bottomRow <= grid.length - 1 && distance + grid[bottomRow][column] < nodesDistance[bottomRow][column]) {
                nodesDistance[bottomRow][column] = distance + grid[bottomRow][column];
                nodesToProcess.add(new int[]{bottomRow, column});
            }

            //left
            if (leftColumn >= 0 && distance + grid[row][leftColumn] < nodesDistance[row][leftColumn]) {
                nodesDistance[row][leftColumn] = distance + grid[row][leftColumn];
                nodesToProcess.add(new int[]{row, leftColumn});
            }
        }
        return -1;
    }
}
