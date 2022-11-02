package com.interview.sde.algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
public class ExitInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {

        char AVOID = '+';
        char TARGET = '.';

        Queue<int[]> steps = new LinkedList<>();
        steps.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = AVOID;

        while (!steps.isEmpty()) {

            int[] stepPosition = steps.poll();

            int row = stepPosition[0];
            int column = stepPosition[1];
            int distanceFromExit = stepPosition[2];

            //Found an exit, and it is not the entrance
            if ((row == 0 || row == maze.length - 1 || column == 0 || column == maze[0].length - 1)
                    && (row != entrance[0] || column != entrance[1])) {
                return distanceFromExit;
            }

            //TOP
            if (row > 0 && maze[row - 1][column] == TARGET) {
                maze[row - 1][column] = AVOID;
                steps.offer(new int[]{row - 1, column, distanceFromExit + 1});
            }

            //BOTTOM
            if (row < maze.length - 1 && maze[row + 1][column] == TARGET) {
                maze[row + 1][column] = AVOID;
                steps.offer(new int[]{row + 1, column, distanceFromExit + 1});
            }

            //LEFT
            if (column > 0 && maze[row][column - 1] == TARGET) {
                maze[row][column - 1] = AVOID;
                steps.offer(new int[]{row, column - 1, distanceFromExit + 1});
            }

            //RIGHT
            if (column < maze[0].length - 1 && maze[row][column + 1] == TARGET) {
                maze[row][column + 1] = AVOID;
                steps.offer(new int[]{row, column + 1, distanceFromExit + 1});
            }
        }
        return -1;
    }
}
