package com.interview.sde.java.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
public class RemoveEdgesGraphFullyTraversable {
    public static class DisjointSet {

        final Map<Integer, Integer> parents;
        final Map<Integer, Integer> size;

        DisjointSet(int n) {
            this.parents = new HashMap<>(n);
            this.size = new HashMap<>(n);
        }

        boolean union(int a, int b) {
            parents.putIfAbsent(a, a);
            size.putIfAbsent(a, 1);

            parents.putIfAbsent(b, b);
            size.putIfAbsent(b, 1);
            int parentA = findParent(a);
            int parentB = findParent(b);
            if (parentA != parentB) {
                //union by rank
                if (size.get(parentA) > size.get(parentB)) {
                    parents.put(parentB, parentA);
                    size.compute(parentA, (k, v) -> v + size.get(parentB));
                } else {
                    parents.put(parentA, parentB);
                    size.compute(parentB, (k, v) -> v + size.get(parentA));
                }
                return true;
            }
            return false;
        }

        int findParent(int i) {
            while (i != parents.get(i)) {
                //path compression
                parents.put(i, i = parents.get(i));
            }
            return parents.get(i);
        }

        int getLargestGraphSize() {
            if (size.isEmpty()) return 0;
            return Collections.max(size.values());
        }

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        final int TYPE = 0;
        final int FROM = 1;
        final int TO = 2;

        final int ALICE = 1;
        final int BOB = 2;
        final int BOTH = 3;

        DisjointSet aliceGraph = new DisjointSet(n);
        DisjointSet bobGraph = new DisjointSet(n);
        Arrays.sort(edges, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        int sum = 0;

        for (int[] edge : edges) {
            if (edge[TYPE] == BOTH && (!aliceGraph.union(edge[FROM], edge[TO]) || !bobGraph.union(edge[FROM], edge[TO]))) {
                sum++;
            } else if (edge[TYPE] == ALICE && !aliceGraph.union(edge[FROM], edge[TO])) {
                sum++;
            } else if (edge[TYPE] == BOB && !bobGraph.union(edge[FROM], edge[TO])) {
                sum++;
            }
        }

        return aliceGraph.getLargestGraphSize() != n || bobGraph.getLargestGraphSize() != n ? -1 : sum;
    }
}
