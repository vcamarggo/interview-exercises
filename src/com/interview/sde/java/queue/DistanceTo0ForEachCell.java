package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
public class DistanceTo0ForEachCell {

    public static void main(String[] args) {
        new DistanceTo0ForEachCell().updateMatrix(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}});
    }

    public int[][] updateMatrix(int[][] grid) {

        Queue<int[]> cellsToProcess = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    cellsToProcess.add(new int[]{r, c, 0});
                    visited[r][c] = true;
                }
            }
        }

        while (!cellsToProcess.isEmpty()) {
            int[] cell = cellsToProcess.poll();
            int row = cell[0];
            int column = cell[1];
            int nextLevel = cell[2] + 1;

            int topRow = row - 1;
            int rightColumn = column + 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;

            //top
            if (topRow >= 0 && !visited[topRow][column]) {
                grid[topRow][column] = nextLevel;
                visited[topRow][column] = true;
                cellsToProcess.add(new int[]{topRow, column, nextLevel});
            }

            //right
            if (rightColumn <= grid[0].length - 1 && !visited[row][rightColumn]) {
                grid[row][rightColumn] = nextLevel;
                visited[row][rightColumn] = true;
                cellsToProcess.add(new int[]{row, rightColumn, nextLevel});
            }

            //bottom
            if (bottomRow <= grid.length - 1 && !visited[bottomRow][column]) {
                grid[bottomRow][column] = nextLevel;
                visited[bottomRow][column] = true;
                cellsToProcess.add(new int[]{bottomRow, column, nextLevel});
            }

            //left
            if (leftColumn >= 0 && !visited[row][leftColumn]) {
                grid[row][leftColumn] = nextLevel;
                visited[row][leftColumn] = true;
                cellsToProcess.add(new int[]{row, leftColumn, nextLevel});
            }
        }

        return grid;
    }
}