package com.interview.sde.algorithm.graph;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/problem
public class CountPaths {

    public static void main(String[] args) {
        new CountPaths().countPaths(7, new int[][]{
                new int[]{0, 6, 7},
                new int[]{0, 1, 2},
                new int[]{1, 2, 3},
                new int[]{1, 3, 3},
                new int[]{6, 3, 3},
                new int[]{3, 5, 1},
                new int[]{6, 5, 1},
                new int[]{2, 5, 1},
                new int[]{0, 4, 5},
                new int[]{4, 6, 2}});
    }

    public int countPaths(int n, int[][] roads) {
        long[][] matrixK = new long[n][n];
        int[][] waysToReachNode = new int[n][n];

        for (long[] arr : matrixK) {
            Arrays.fill(arr, Long.MAX_VALUE);
        }

        for (int[] arr : waysToReachNode) {
            Arrays.fill(arr, 1);
        }

        for (int[] road : roads) {
            int node1Id = road[0];
            int node2Id = road[1];
            matrixK[node1Id][node2Id] = road[2];
            matrixK[node2Id][node1Id] = road[2];
            waysToReachNode[node1Id][node2Id] = 1;
            waysToReachNode[node2Id][node1Id] = 1;
        }

        return floydWarshall(matrixK, waysToReachNode);
    }

    private int floydWarshall(long[][] matrixK, int[][] waysToReachNode) {
        int MOD = 1_000_000_000 + 7;
        int size = matrixK.length;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    long ikValue = matrixK[i][k];
                    long jkValue = matrixK[k][j];
                    if (ikValue != Long.MAX_VALUE && jkValue != Long.MAX_VALUE) {
                        if (matrixK[i][j] > ikValue + jkValue) {
                            matrixK[i][j] = ikValue + jkValue;
                            waysToReachNode[i][j] = waysToReachNode[i][k] * waysToReachNode[k][j] % MOD;
                        } else if (matrixK[i][j] == ikValue + jkValue) {
                            waysToReachNode[i][j] = (waysToReachNode[i][j] + waysToReachNode[i][k] * waysToReachNode[k][j] % MOD) % MOD;
                        }
                    }
                }
            }
        }
        return waysToReachNode[0][size - 1];
    }


}

