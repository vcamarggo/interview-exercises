package com.interview.sde.mock.icaro.graph;

import java.util.*;

//Implementation of Dijkstra//BellmanFord//FloydWarshall algorithms for search in Graphs
//It doesn't implement any custom class. 20% faster than Graph.java
public class GraphNoExtraClasses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        int[][] edges = new int[vertex + 1][vertex + 1];
        int[] nodesDistance = new int[vertex + 1];

        Arrays.fill(nodesDistance, Integer.MAX_VALUE);

        String[] startEnd = scanner.nextLine().split(" ");
        int startId = Integer.parseInt(startEnd[0]);
        int endId = Integer.parseInt(startEnd[1]);

        //nodes ID ignored
        scanner.nextLine();

        for (int i = 0; i < edgesNumber; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);
            edges[node1Id][node2Id] = Integer.parseInt(edgeData[2]);
        }

        System.out.println("From: " + startId + " - To: " + endId);

        dijkstra(Arrays.copyOf(nodesDistance, nodesDistance.length), edges, startId, endId);

        bellmanFord(Arrays.copyOf(nodesDistance, nodesDistance.length), edges, startId, endId);

        floydWarshall(edges, startId, endId);
    }

    private static void dijkstra(int[] nodesDistance, int[][] edges, int startId, int endId) {
        PriorityQueue<Integer> nodesToProcess = new PriorityQueue<>(Comparator.comparingInt(o -> nodesDistance[o]));

        nodesDistance[startId] = 0;
        nodesToProcess.add(startId);
        while (!nodesToProcess.isEmpty() && nodesToProcess.peek() != endId) {
            int node = nodesToProcess.poll();
            for (int i = 1; i < edges[node].length; i++) {
                if (edges[node][i] != 0) {
                    int newDistance = nodesDistance[node] == Integer.MAX_VALUE ? Integer.MAX_VALUE : nodesDistance[node] + edges[node][i];
                    if (newDistance < nodesDistance[i]) {
                        nodesDistance[i] = newDistance;
                        nodesToProcess.add(i);
                    }
                }
            }
        }
        System.out.println("Dijkstra " + nodesDistance[endId]);
    }

    private static void bellmanFord(int[] nodesDistance, int[][] edges, int startId, int endId) {
        nodesDistance[startId] = 0;
        for (int i = 1; i < nodesDistance.length - 1; i++) {
            for (int node = 1; node < nodesDistance.length; node++) {
                for (int edge = 1; edge < edges[node].length; edge++) {
                    if (edges[node][edge] != 0) {
                        int newDistance = nodesDistance[node] == Integer.MAX_VALUE ? Integer.MAX_VALUE : nodesDistance[node] + edges[node][edge];
                        if (newDistance < nodesDistance[edge]) {
                            nodesDistance[edge] = newDistance;
                        }
                    }
                }
            }
        }
        System.out.println("BellmanFord " + nodesDistance[endId]);
    }

    private static void floydWarshall(int[][] edges, int startId, int endId) {

        int[][] matrixPrev = initMatrixFloydWarshall(edges);
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

        System.out.println("FloydWarshall " + matrixK[startId][endId]);
        for (int[] row : matrixK)
            System.out.println(Arrays.toString(row));
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
