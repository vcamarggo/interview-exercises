package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/flood-fill/
public class FloodFill {
    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int TARGET = image[sr][sc];
        if (newColor != TARGET) {
            image[sr][sc] = newColor;

            Queue<Integer> cellsToProcess = new LinkedList<>();

            cellsToProcess.add(sr);
            cellsToProcess.add(sc);

            while (!cellsToProcess.isEmpty()) {
                int row = cellsToProcess.poll();
                int column = cellsToProcess.poll();

                int topRow = row - 1;
                int rightColumn = column + 1;
                int bottomRow = row + 1;
                int leftColumn = column - 1;

                //top
                if (topRow >= 0 && image[topRow][column] == TARGET) {
                    image[topRow][column] = newColor;
                    cellsToProcess.add(topRow);
                    cellsToProcess.add(column);
                }

                //right
                if (rightColumn <= image[0].length - 1 && image[row][rightColumn] == TARGET) {
                    image[row][rightColumn] = newColor;
                    cellsToProcess.add(row);
                    cellsToProcess.add(rightColumn);
                }

                //bottom
                if (bottomRow <= image.length - 1 && image[bottomRow][column] == TARGET) {
                    image[bottomRow][column] = newColor;
                    cellsToProcess.add(bottomRow);
                    cellsToProcess.add(column);
                }

                //left
                if (leftColumn >= 0 && image[row][leftColumn] == TARGET) {
                    image[row][leftColumn] = newColor;
                    cellsToProcess.add(row);
                    cellsToProcess.add(leftColumn);
                }

            }
        }
        return image;
    }

    public static void main(String[] args) {
        floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 1, 1}}, 1, 1, 1);
    }

}

