package com.interview.sde.algorithm.graph;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
public class CitySmallestNumberNeighborsThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrixK = new int[n][n];

        for (int[] arr : matrixK) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int[] road : edges) {
            int node1Id = road[0];
            int node2Id = road[1];
            matrixK[node1Id][node2Id] = road[2];
            matrixK[node2Id][node1Id] = road[2];
        }
        floydWarshall(matrixK);

        return getMaxIdxWithMinCityCloserThanThreshold(distanceThreshold, matrixK);
    }

    private int getMaxIdxWithMinCityCloserThanThreshold(int distanceThreshold, int[][] matrixK) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < matrixK.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrixK[0].length; j++) {
                if (i != j && matrixK[i][j] <= distanceThreshold) {
                    sum++;
                }
            }
            if (sum <= min) {
                min = sum;
                minIdx = Math.max(minIdx, i);
            }
        }
        return minIdx;
    }

    private void floydWarshall(int[][] matrixK) {
        int size = matrixK.length;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int ikValue = matrixK[i][k];
                    int jkValue = matrixK[j][k];
                    if (ikValue != Integer.MAX_VALUE && jkValue != Integer.MAX_VALUE && matrixK[i][j] > ikValue + jkValue) {
                        matrixK[i][j] = ikValue + jkValue;
                    }
                }
            }
        }
    }
}
