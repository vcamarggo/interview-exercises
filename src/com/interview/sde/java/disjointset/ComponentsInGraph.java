package com.interview.sde.java.disjointset;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/components-in-graph/problem
public class ComponentsInGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DisjointSet dSet = new DisjointSet(2 * n);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            dSet.union(a, b);
        }
        int max = 1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int size = dSet.getCommunitySizeOf(i);
            max = Math.max(max, size);
            if (size > 1) {
                min = Math.min(min, size);
            }
        }
        System.out.println(min + " " + max);
    }

    private static class DisjointSet {
        private final int[] parent;
        private final int[] size;

        public DisjointSet(int n) {
            this.parent = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (parent[i] != i) {
                //In theory path compression would make this faster, but in my tests, it did not.
                //That is probably due to recursion overhead
                i = parent[i];
            }
            return i;
        }

        void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent != bParent) {
                //max min to do union by rank, where rank is the number natural ordering
                int max = Math.max(aParent, bParent);
                int min = Math.min(aParent, bParent);
                size[max] += size[min];
                parent[min] = max;
            }
        }

        public int getCommunitySizeOf(int id) {
            return size[find(id)];
        }
    }
}
