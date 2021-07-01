package com.interview.sde.algorithm.graph;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RedundantConnection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 4}, new int[]{1, 5}})));
    }

    private static int[] findRedundantConnection(int[][] edges) {
        int[] parents = IntStream.rangeClosed(0, edges.length).toArray();

        for (int[] edge : edges) {
            if (!union(parents, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return null;
    }

    private static boolean union(int[] parents, int a, int b) {
        int aParent = findParent(parents, a);
        int bParent = findParent(parents, b);
        if (aParent != bParent) {
            int min = Math.min(aParent, bParent);
            int max = Math.max(aParent, bParent);
            parents[min] = parents[max];
            return true;
        }
        return false;
    }

    private static int findParent(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return i;
    }
}
