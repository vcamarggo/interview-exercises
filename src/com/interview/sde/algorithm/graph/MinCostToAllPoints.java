package com.interview.sde.algorithm.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostToAllPoints {

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{new int[]{0, 0}, new int[]{2, 2}, new int[]{3, 10}, new int[]{5, 2}, new int[]{7, 0}}));
        System.out.println(minCostConnectPoints(new int[][]{new int[]{3, 12}, new int[]{-2, 5}, new int[]{-4, 1}}));
    }

    static int minCostConnectPoints(int[][] points) {
        return kruskal(points);
    }

    private static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static int kruskal(final int[][] edges) {
        PriorityQueue<int[]> edgesToProcess = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        int[] parents = new int[edges.length];


        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;

            for (int j = i + 1; j < edges.length; j++) {
                int manhattanDistance = calculateManhattanDistance(edges[i][0], edges[i][1], edges[j][0], edges[j][1]);
                edgesToProcess.add(new int[]{i, j, manhattanDistance});
            }
        }

        int solution = 0;
        int solutionSize = 0;
        while (solutionSize != edges.length - 1) {
            int[] edge = edgesToProcess.poll();

            //No cycle created
            if (findParent(parents, edge[0]) != findParent(parents, edge[1])) {
                union(parents, edge[0], edge[1]);
                solution += edge[2];
                solutionSize++;
            }
        }

        return solution;
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
