package com.interview.sde.java.disjointset;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        for (int i = 0; i < parents.length; i++) {
            //each number is its own parent, i.e. has a self edge in a graph
            parents[i] = i;
        }

        for (int from = 0; from < isConnected.length; from++) {
            for (int to = 0; to < isConnected.length; to++) {
                if (isConnected[from][to] == 1) {
                    union(parents, from, to);
                }
            }
        }

        // Find numbers that are their own parent, i.e. either are single node, or a parent of some others.
        // Each parent is an island.
        //50% slower when compared to a for-i on leetcode, but syntax looks natural to me
        return (int) IntStream.range(0, parents.length).filter(i -> parents[i] == i).count();
    }

    public static void union(int[] parents, int a, int b) {
        int aParent = findParentIterative(parents, a);
        int bParent = findParentIterative(parents, b);
        if (aParent != bParent) {
            int min = Math.min(aParent, bParent);
            int max = Math.max(aParent, bParent);
            parents[min] = parents[max];
        }
    }

    // Performance was 75% slower on Leetcode
    public static int findParentRecursive(int[] parents, int i) {
        if (i != parents[i]) {
            return findParentRecursive(parents, parents[i]);
        }
        return i;
    }

    public static int findParentIterative(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{new int[]{1, 0, 0, 1}, new int[]{0, 1, 1, 0}
                , new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 1}}));
        System.out.println(findCircleNum(new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}
                , new int[]{0, 0, 1}}));
    }

    //DFS-like version
    public int findCircleNum2(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int counter = 0;

        for (int start = 0; start < isConnected.length; start++) {
            counter += dfs(start, isConnected, visited);
        }
        return counter;
    }

    private int dfs(int start, int[][] isConnected, Set<Integer> visited) {
        if (!visited.contains(start)) {
            visited.add(start);

            for (int end = 0; end < isConnected.length; end++) {
                if (isConnected[start][end] == 1)
                    dfs(end, isConnected, visited);
            }

            return 1;
        }
        return 0;
    }
}
