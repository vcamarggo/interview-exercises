package com.interview.sde.java.disjointset;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/friend-circle-queries/problem
public class MaxConnectComponent {
    static int[] maxCircle(int[][] queries) {
        int[] maxSize = new int[queries.length];
        int max = Integer.MIN_VALUE;

        DisjointSet dSet = new DisjointSet();

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int unionSize = dSet.union(a, b);
            maxSize[i] = (max = Math.max(max, unionSize));
        }
        return maxSize;
    }

    private static class DisjointSet {
        //Pre-initialize the load factor based on 2*queries length improves speed
        private final Map<Integer, ParentSize> parentSize = new HashMap<>();

        int find(int i) {
            //Pre-initialize the hashMap on query read would improve, but for simplicity, kept putIfAbsent here
            parentSize.putIfAbsent(i, new ParentSize(i));
            while (parentSize.get(i).parent != i) {
                i = parentSize.get(i).parent;
            }
            return i;
        }

        int union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent != bParent) {
                int max = Math.max(aParent, bParent);
                int min = Math.min(aParent, bParent);
                parentSize.get(max).size += parentSize.get(min).size;
                parentSize.get(min).parent = max;
                return parentSize.get(max).size;
            }
            return parentSize.get(aParent).size;
        }

        private static class ParentSize {
            int parent;
            int size;

            public ParentSize(int parent) {
                this.parent = parent;
                this.size = 1;
            }

        }
    }
}
