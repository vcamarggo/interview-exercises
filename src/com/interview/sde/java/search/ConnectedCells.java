package com.interview.sde.java.search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//Flexible implementation of BFS/DFS using Dequeue
//https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class ConnectedCells {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        Deque<Node> nodes = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int groupSize = 0;

        int target = 1;
        int avoid = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {

                    matrix[i][j] = avoid;

                    nodes.add(new Node(i, j));
                    groupSize = 0;

                    while (!nodes.isEmpty()) {
                        groupSize++;

                        Node n = nodes.removeLast();
                        int row = n.row;
                        int column = n.column;

                        int topRow = row - 1;
                        int rightColumn = column + 1;
                        int bottomRow = row + 1;
                        int leftColumn = column - 1;

                        //top
                        if (topRow >= 0 && matrix[topRow][column] == target) {
                            matrix[topRow][column] = avoid;
                            nodes.add(new Node(topRow, column));
                        }

                        //top-right
                        if (topRow >= 0 && rightColumn <= matrix[0].length - 1 && matrix[topRow][rightColumn] == target) {
                            matrix[topRow][rightColumn] = avoid;
                            nodes.add(new Node(topRow, rightColumn));
                        }

                        //right
                        if (rightColumn <= matrix[0].length - 1 && matrix[row][rightColumn] == target) {
                            matrix[row][rightColumn] = avoid;
                            nodes.add(new Node(row, rightColumn));
                        }

                        //bottom-right
                        if (bottomRow <= matrix.length - 1 && rightColumn <= matrix[0].length - 1 && matrix[bottomRow][rightColumn] == target) {
                            matrix[bottomRow][rightColumn] = avoid;
                            nodes.add(new Node(bottomRow, rightColumn));
                        }

                        //bottom
                        if (bottomRow <= matrix.length - 1 && matrix[bottomRow][column] == target) {
                            matrix[bottomRow][column] = avoid;
                            nodes.add(new Node(bottomRow, column));
                        }

                        //bottom-left
                        if (bottomRow <= matrix.length - 1 && leftColumn >= 0 && matrix[bottomRow][leftColumn] == target) {
                            matrix[bottomRow][leftColumn] = avoid;
                            nodes.add(new Node(bottomRow, leftColumn));
                        }

                        //left
                        if (leftColumn >= 0 && matrix[row][leftColumn] == target) {
                            matrix[row][leftColumn] = avoid;
                            nodes.add(new Node(row, leftColumn));
                        }

                        //top-left
                        if (topRow >= 0 && leftColumn >= 0 && matrix[topRow][leftColumn] == target) {
                            matrix[topRow][leftColumn] = avoid;
                            nodes.add(new Node(topRow, leftColumn));
                        }

                    }
                }
                max = Math.max(max, groupSize);
            }
        }
        return max;
    }

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

        int result = connectedCell(matrix);

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

