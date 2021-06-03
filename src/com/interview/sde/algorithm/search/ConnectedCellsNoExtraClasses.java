package com.interview.sde.algorithm.search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//Flexible implementation of BFS/DFS using Dequeue
//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class ConnectedCellsNoExtraClasses {

    static int connectedCellDFS(int[][] matrix) {
        return connectedCell(matrix, true);
    }

    static int connectedCellBFS(int[][] matrix) {
        return connectedCell(matrix, false);
    }

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix, boolean isDFS) {
        int max = Integer.MIN_VALUE;

        final int TARGET = 1;
        final int AVOID = 0;
        int size = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == TARGET) {
                    Deque<int[]> processStructure = new ArrayDeque<>();
                    processStructure.add(new int[]{i, j});
                    matrix[i][j] = AVOID;

                    size = 0;
                    while (!processStructure.isEmpty()) {
                        size++;

                        int[] nodeToProcess = isDFS ? processStructure.pollLast() : processStructure.pollFirst();
                        int row = nodeToProcess[0];
                        int column = nodeToProcess[1];

                        int topRow = row - 1;
                        int rightColumn = column + 1;
                        int bottomRow = row + 1;
                        int leftColumn = column - 1;

                        //top
                        if (topRow >= 0 && matrix[topRow][column] == TARGET) {
                            matrix[topRow][column] = AVOID;
                            processStructure.add(new int[]{topRow, column});
                        }

                        //bottom
                        if (bottomRow < matrix.length && matrix[bottomRow][column] == TARGET) {
                            matrix[bottomRow][column] = AVOID;
                            processStructure.add(new int[]{bottomRow, column});
                        }

                        //right
                        if (rightColumn < matrix[0].length && matrix[row][rightColumn] == TARGET) {
                            matrix[row][rightColumn] = AVOID;
                            processStructure.add(new int[]{row, rightColumn});
                        }

                        //left
                        if (leftColumn >= 0 && matrix[row][leftColumn] == TARGET) {
                            matrix[row][leftColumn] = AVOID;
                            processStructure.add(new int[]{row, leftColumn});
                        }

                        //top-right
                        if (topRow >= 0 && rightColumn < matrix[0].length && matrix[topRow][rightColumn] == TARGET) {
                            matrix[topRow][rightColumn] = AVOID;
                            processStructure.add(new int[]{topRow, rightColumn});
                        }

                        //bottom-right
                        if (bottomRow < matrix.length && rightColumn < matrix[0].length && matrix[bottomRow][rightColumn] == TARGET) {
                            matrix[bottomRow][rightColumn] = AVOID;
                            processStructure.add(new int[]{bottomRow, rightColumn});
                        }

                        //bottom-left
                        if (bottomRow < matrix.length && leftColumn >= 0 && matrix[bottomRow][leftColumn] == TARGET) {
                            matrix[bottomRow][leftColumn] = AVOID;
                            processStructure.add(new int[]{bottomRow, leftColumn});
                        }

                        //top-left
                        if (topRow >= 0 && leftColumn >= 0 && matrix[topRow][leftColumn] == TARGET) {
                            matrix[topRow][leftColumn] = AVOID;
                            processStructure.add(new int[]{topRow, leftColumn});
                        }
                    }
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCellDFS(matrix);

        System.out.println(result);

        scanner.close();
    }

    private static class Node {
        int row;
        int column;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

