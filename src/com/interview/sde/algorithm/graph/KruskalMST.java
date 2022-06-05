package com.interview.sde.algorithm.graph;

import java.util.*;

//https://www.hackerrank.com/challenges/kruskalmstrsub/problem
public class KruskalMST {

    public static void main(String[] args) {
        System.out.println(kruskal(5,
                List.of(1, 1, 1, 1, 2, 3, 4),
                List.of(2, 3, 4, 5, 3, 4, 5),
                List.of(20, 50, 70, 90, 30, 40, 60)));
    }

    private static int kruskal(int n, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        final int[][] edges = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            Arrays.fill(edge, -1);
        }

        for (int i = 0; i < gFrom.size(); i++) {
            edges[gFrom.get(i)][gTo.get(i)] = gWeight.get(i);
            edges[gTo.get(i)][gFrom.get(i)] = gWeight.get(i);
        }

        PriorityQueue<int[]> edgesToProcess = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        ArrayList<int[]> solution = new ArrayList<>();
        int[] parents = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;

            for (int j = i + 1; j < edges[0].length; j++) {
                if (edges[i][j] != -1) {
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

        return solution.stream().mapToInt(edge -> edge[2]).sum();
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
