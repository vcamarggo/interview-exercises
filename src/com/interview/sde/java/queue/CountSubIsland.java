package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/count-sub-islands/
public class CountSubIsland {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslandCount = 0;

        Queue<Integer> rowColumn = new LinkedList<>();

        for (int row = 0; row < grid2.length; row++) {
            for (int column = 0; column < grid2[0].length; column++) {
                boolean isSubIsland = false;

                if (grid2[row][column] == 1) {
                    grid2[row][column] = 0;
                    rowColumn.offer(row);
                    rowColumn.offer(column);
                    isSubIsland = true;
                }

                while (!rowColumn.isEmpty()) {
                    int neighborRow = rowColumn.poll();
                    int neighborColumn = rowColumn.poll();

                    if (grid1[neighborRow][neighborColumn] != 1) {
                        isSubIsland = false;
                    }

                    if (neighborRow - 1 >= 0 && grid2[neighborRow - 1][neighborColumn] == 1) {
                        grid2[neighborRow - 1][neighborColumn] = 0;
                        rowColumn.offer(neighborRow - 1);
                        rowColumn.offer(neighborColumn);
                    }

                    if (neighborRow + 1 < grid2.length && grid2[neighborRow + 1][neighborColumn] == 1) {
                        grid2[neighborRow + 1][neighborColumn] = 0;
                        rowColumn.offer(neighborRow + 1);
                        rowColumn.offer(neighborColumn);
                    }

                    if (neighborColumn - 1 >= 0 && grid2[neighborRow][neighborColumn - 1] == 1) {
                        grid2[neighborRow][neighborColumn - 1] = 0;
                        rowColumn.offer(neighborRow);
                        rowColumn.offer(neighborColumn - 1);
                    }

                    if (neighborColumn + 1 < grid2[0].length && grid2[neighborRow][neighborColumn + 1] == 1) {
                        grid2[neighborRow][neighborColumn + 1] = 0;
                        rowColumn.offer(neighborRow);
                        rowColumn.offer(neighborColumn + 1);
                    }

                }
                if (isSubIsland) {
                    subIslandCount++;
                }
            }
        }
        return subIslandCount;
    }

}
