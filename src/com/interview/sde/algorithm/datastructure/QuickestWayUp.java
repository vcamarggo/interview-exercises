package com.interview.sde.algorithm.datastructure;

import java.util.HashMap;
import java.util.Scanner;


//https://www.hackerrank.com/challenges/the-quickest-way-up/problem
public class QuickestWayUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {

            HashMap<Integer, Integer> outliers = new HashMap<>();

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            initArraySnakeLadders(scanner, outliers, n, ladders);

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            initArraySnakeLadders(scanner, outliers, m, snakes);

            final int[][] edges = initMatrixFloydWarshall(100);

            for (int i = 1; i < 100; i++) {

                outliers.computeIfPresent(i, (key, value) -> edges[key][value] = 0);
                outliers.computeIfAbsent(i, (key) -> {
                    edges[key][Math.min(100, key + 1)] = 1;
                    edges[key][Math.min(100, key + 2)] = 1;
                    edges[key][Math.min(100, key + 3)] = 1;
                    edges[key][Math.min(100, key + 4)] = 1;
                    edges[key][Math.min(100, key + 5)] = 1;
                    edges[key][Math.min(100, key + 6)] = 1;
                    return 0;
                });

            }

            int[][] floydWarshallMatrix = floydWarshall(edges);
            int solution = floydWarshallMatrix[1][100] == Integer.MAX_VALUE ? -1 : floydWarshallMatrix[1][100];
            System.out.println(solution);

        }


    }

    private static void initArraySnakeLadders(Scanner scanner, HashMap<Integer, Integer> outliers, int n, int[][] array) {
        for (int i = 0; i < n; i++) {
            String[] snakesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int begin = Integer.parseInt(snakesRowItems[0]);
            int end = Integer.parseInt(snakesRowItems[1]);
            outliers.put(begin, end);
            array[i][0] = begin;
            array[i][1] = end;
        }
    }


    private static int[][] floydWarshall(int[][] matrixPrev) {
        int size = matrixPrev.length;
        int[][] matrixK = new int[size][size];

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int ikValue = matrixPrev[i][k];
                    int jkValue = matrixPrev[k][j];
                    if (ikValue == Integer.MAX_VALUE || jkValue == Integer.MAX_VALUE) {
                        matrixK[i][j] = matrixPrev[i][j];
                    } else {
                        matrixK[i][j] = Math.min(matrixPrev[i][j], ikValue + jkValue);
                    }
                }
            }
            matrixPrev = matrixK;
        }

        return matrixK;
    }

    private static int[][] initMatrixFloydWarshall(int size) {
        int[][] initializedEdges = new int[size + 1][size + 1];
        for (int i = 0; i < initializedEdges.length; i++) {
            for (int j = 0; j < initializedEdges.length; j++) {
                if (initializedEdges[i][j] == 0 && i != j) {
                    initializedEdges[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return initializedEdges;
    }
}
