package com.interview.sde.hackerrank.algorithm.disjointset;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/merging-communities/problem
public class MergingCommunities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        DisjointSet dSet = new DisjointSet(n);
        for (int i = 0; i < q; i++) {
            String op = sc.next();
            switch (op) {
                case "Q":
                    int p = sc.nextInt();
                    System.out.println(dSet.getCommunitySizeOf(p));
                    break;
                case "M":
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    dSet.union(a, b);
                    break;
            }
        }
    }

    private static class DisjointSet {
        private int[] parent, size;

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
                i = parent[i];
            }
            return i;
        }

        void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent != bParent) {
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
