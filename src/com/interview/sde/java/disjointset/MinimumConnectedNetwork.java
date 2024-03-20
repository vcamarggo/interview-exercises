package com.interview.sde.java.disjointset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class MinimumConnectedNetwork {

    Map<Integer, Integer> parents = new HashMap<>();
    Map<Integer, Integer> ranks = new HashMap<>();

    public void union(int a, int b) {

        parents.putIfAbsent(a, a);
        ranks.putIfAbsent(a, 1);

        parents.putIfAbsent(b, b);
        ranks.putIfAbsent(b, 1);

        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            if (ranks.get(parentA) > ranks.get(parentB)) {
                parents.put(parentB, parentA);
                ranks.compute(parentA, (k, v) -> v + ranks.get(parentB));
            } else {
                parents.put(parentA, parentB);
                ranks.compute(parentB, (k, v) -> v + ranks.get(parentA));

            }
        }
    }

    public int find(int i) {
        while (i != parents.get(i)) {
            parents.put(i, i = parents.get(i));
        }
        return i;
    }

    public int makeConnected(int n, int[][] connections) {
        //Minimum required connections to form a complete graph
        if (connections.length < n - 1) {
            return -1;
        }

        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        Set<Integer> uniqueParents = new HashSet<>();

        for (Integer i : parents.keySet()) {
            parents.put(i, find(i));
            uniqueParents.add(parents.get(i));
        }

        //Number of nodes, minus the number of already connected nodes as we would not need their connections, plus the number of not connected island of nodes - 1
        return n - parents.size() + uniqueParents.size() - 1;
    }

    public static void main(String[] args) {
        new MinimumConnectedNetwork().makeConnected(11, new int[][]{{3, 4}, {5, 6}, {0, 3}, {0, 5}, {1, 7}, {0, 4}, {2, 6}, {1, 6}, {1, 3}, {3, 7}, {4, 5}, {3, 5}});
        new MinimumConnectedNetwork().makeConnected(3, new int[][]{{0, 1}, {0, 2}});
        new MinimumConnectedNetwork().makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3,4}, {2,3}});
        new MinimumConnectedNetwork().makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0,3}, {1,2}});
    }
}
