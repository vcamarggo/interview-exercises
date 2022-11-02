package com.interview.sde.java.graph;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {
    public static class DisjointSet {
        final Map<Integer, Integer> parents;
        final Map<Integer, Integer> ranks;

        DisjointSet(int n) {
            this.parents = new HashMap<>();
            this.ranks = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                parents.put(i, i);
                ranks.put(i, 1);
            }
        }

        void union(int a, int b) {
            int parentA = findParent(a);
            int parentB = findParent(b);
            if (parentA != parentB) {
                if (ranks.get(parentA) > ranks.get(parentB)) {
                    parents.put(parentB, parentA);
                    ranks.compute(parentA, (key, value) -> value + ranks.get(parentB));
                } else {
                    parents.put(parentA, parentB);
                    ranks.compute(parentB, (key, value) -> value + ranks.get(parentA));
                }
            }
        }

        int findParent(int i) {
            while (i != parents.get(i)) {
                parents.put(i, i = parents.get(i));
            }
            return parents.get(i);
        }
    }


    public boolean possibleBipartition(int n, int[][] dislikes) {
        DisjointSet ds = new DisjointSet(n);
        Map<Integer, Integer> partitionMapped = new HashMap<>(n);

        for (int[] dislikePair : dislikes) {
            int a = dislikePair[0];
            int b = dislikePair[1];
            if (ds.findParent(a) == ds.findParent(b)) {
                return false;
            }

            if (partitionMapped.containsKey(a)) {
                ds.union(partitionMapped.get(a), b);
            } else {
                partitionMapped.put(a, b);
            }

            if (partitionMapped.containsKey(b)) {
                ds.union(partitionMapped.get(b), a);
            } else {
                partitionMapped.put(b, a);
            }
        }
        return true;
    }
}
