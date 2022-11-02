package com.interview.sde.java.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
public class DFS {

    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static void cleanVisited(int[][] visited) {
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited[0].length; y++) {
                visited[x][y] = WHITE;
            }
        }
    }

    // Complete the maxRegion function below.
    static int maxRegion(int[][] array) {

        int[][] visited = new int[array.length][array[0].length];

        int maxStep = 0;

        Stack<Node> toVisit = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 1) {
                    cleanVisited(visited);
                    int tempMax = 1;

                    toVisit.push(new Node(i, j));
                    visited[i][j] = GRAY;

                    while (!toVisit.empty()) {

                        Node n = toVisit.pop();

                        int x = n.x;
                        int y = n.y;

                        if ((x > 0 && y > 0) && array[x - 1][y - 1] == 1) {

                            if (visited[x - 1][y - 1] == WHITE) {
                                // System.out.println("diagonal cima esquerda");
                                visited[x - 1][y - 1] = GRAY;
                                toVisit.add(new Node(x - 1, y - 1));
                                tempMax++;
                            }

                        }
                        if ((x > 0) && array[x - 1][y] == 1) {

                            if (visited[x - 1][y] == WHITE) {
                                //System.out.println("cima");
                                visited[x - 1][y] = GRAY;
                                toVisit.add(new Node(x - 1, y));
                                tempMax++;
                            }

                        }
                        if ((x > 0 && y < array[0].length - 1) && array[x - 1][y + 1] == 1) {

                            if (visited[x - 1][y + 1] == WHITE) {
                                //System.out.println("diagonal cima direita");
                                visited[x - 1][y + 1] = GRAY;
                                toVisit.add(new Node(x - 1, y + 1));
                                tempMax++;
                            }

                        }
                        if ((y < array[0].length - 1) && array[x][y + 1] == 1) {

                            if (visited[x][y + 1] == WHITE) {
                                // System.out.println("direita");
                                visited[x][y + 1] = GRAY;
                                toVisit.add(new Node(x, y + 1));
                                tempMax++;
                            }

                        }
                        if ((y > 0) && array[x][y - 1] == 1) {

                            if (visited[x][y - 1] == WHITE) {
                                //System.out.println("esquerda");
                                visited[x][y - 1] = GRAY;
                                toVisit.add(new Node(x, y - 1));
                                tempMax++;
                            }

                        }
                        if ((x < array.length - 1 && y > 0) && array[x + 1][y - 1] == 1) {

                            if (visited[x + 1][y - 1] == WHITE) {
                                // System.out.println("diagonal baixo esquerda");
                                visited[x + 1][y - 1] = GRAY;
                                toVisit.add(new Node(x + 1, y - 1));
                                tempMax++;
                            }

                        }
                        if ((x < array.length - 1) && array[x + 1][y] == 1) {

                            if (visited[x + 1][y] == WHITE) {
                                // System.out.println("baixo");
                                visited[x + 1][y] = GRAY;
                                toVisit.add(new Node(x + 1, y));
                                tempMax++;
                            }

                        }
                        if ((x < array.length - 1 && y < array[0].length - 1) && array[x + 1][y + 1] == 1) {

                            if (visited[x + 1][y + 1] == WHITE) {
                                //System.out.println("diagonal baixo direita");
                                visited[x + 1][y + 1] = GRAY;
                                toVisit.add(new Node(x + 1, y + 1));
                                tempMax++;
                            }

                        }
                        visited[x][y] = BLACK;
                    }
                    maxStep = Math.max(tempMax, maxStep);
                }
            }
        }

        return maxStep;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
