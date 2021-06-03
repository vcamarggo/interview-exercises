package com.interview.sde.algorithm.datastructure;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights/problem
public class FloydCityofBlindingLights {

    static int[][] matrixK;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        int[][] edges = new int[vertex + 1][vertex + 1];

        for (int i = 0; i < edgesNumber; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);
            edges[node1Id][node2Id] = Integer.parseInt(edgeData[2]);
        }

        floydWarshall(edges);

        int queries = Integer.parseInt(scanner.nextLine());
        for (; queries > 0; queries--) {
            String[] startEnd = scanner.nextLine().split(" ");
            int startId = Integer.parseInt(startEnd[0]);
            int endId = Integer.parseInt(startEnd[1]);
            System.out.println(matrixK[startId][endId] == Integer.MAX_VALUE ? - 1 : matrixK[startId][endId]);
        }
    }


    private static void floydWarshall(int[][] edges) {

        int[][] matrixPrev = initMatrixFloydWarshall(edges);
        int size = matrixPrev.length;
        matrixK = new int[size][size];

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
    }

    private static int[][] initMatrixFloydWarshall(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (edges[i][j] == 0 && i != j) {
                    edges[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return edges;
    }

}

