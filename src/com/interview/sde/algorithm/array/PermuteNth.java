package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/permutation-sequence/
public class PermuteNth {

    static int kth;

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }

    static String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        kth = k;
        return getPermutation(n, new StringBuilder(), visited);
    }

    public static String getPermutation(int n, StringBuilder s, boolean[] vis) {

        if (s.length() == n) {
            if (--kth == 0) {
                return s.toString();
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (!vis[i]) {
                vis[i] = true;
                s.append(i);
                String solution = getPermutation(n, s, vis);
                if (solution != null) {
                    return solution;
                }
                s.deleteCharAt(s.length() - 1);
                vis[i] = false;
            }
        }
        return null;
    }

}
