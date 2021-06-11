package com.interview.sde.algorithm.graph;

import java.util.*;

//Implementation of Kruskal's algorithm for generating MST
public class MST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        int[][] edges = new int[vertex + 1][vertex + 1];

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
            edges[node2Id][node1Id] = Integer.parseInt(edgeData[2]);
        }

        kruskal(edges);
    }

    private static void kruskal(int[][] edges) {
        PriorityQueue<int[]> edgesToProcess = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        ArrayList<int[]> solution = new ArrayList<>();
        int[] parents = new int[edges.length];


        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;

            for (int j = i + 1; j < edges[0].length; j++) {
                if (edges[i][j] != 0) {
                    edgesToProcess.add(new int[]{i, j, edges[i][j]});
                }
            }
        }

        while (solution.size() != edges.length - 2) {
            int[] edge = edgesToProcess.poll();

            //No cycle created
            if (findParent(parents, edge[0]) != findParent(parents, edge[1])) {
                union(parents, edge[0], edge[1]);
                solution.add(edge);
            }
        }

        for (int[] edge : solution) {
            System.out.println(String.format("Edge %02d <-> %02d - weight %s", edge[0], edge[1], edge[2]));
        }
    }

    public static void union(int[] parents, int a, int b) {
        int aParent = findParent(parents, a);
        int bParent = findParent(parents, b);
        if (aParent != bParent) {
            int min = Math.min(aParent, bParent);
            int max = Math.max(aParent, bParent);
            parents[min] = parents[max];
        }
    }

    private static int findParent(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return i;
    }

}
