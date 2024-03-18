package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutation-sequence/
public class PermuteNth {

    static int kth;

    public static void main(String[] args) {
//        System.out.println(getPermutation(3, 3));
        System.out.printf(getPermutation(new int[]{1, 2, 3}, new ArrayList<>(), new boolean[3 + 1]).toString());
    }

    static String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n + 1];
        kth = k;
        return getPermutation(n, new StringBuilder(), visited);
    }

    public static String getPermutation(int n, StringBuilder s, boolean[] vis) {
        if (s.length() == n) {
            return --kth == 0 ? s.toString() : null;
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

    public static List<List<Integer>> getPermutation(int[] nums, List<Integer> s, boolean[] vis) {
        List<List<Integer>> solution = new ArrayList<>();
        if (s.size() == nums.length) {
            solution.add(new ArrayList<>(s));
            return solution;
        }

        for (int i : nums) {
            if (!vis[i]) {
                vis[i] = true;
                s.add(i);
                solution.addAll(getPermutation(nums, s, vis));
                s.remove(s.size() - 1);
                vis[i] = false;
            }
        }
        return solution;
    }

}
