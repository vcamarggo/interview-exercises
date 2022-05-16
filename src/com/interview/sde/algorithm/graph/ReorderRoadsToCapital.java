package com.interview.sde.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
public class ReorderRoadsToCapital {
    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Set<Integer> canReachCapital = new HashSet<>();
        canReachCapital.add(0);

        while (canReachCapital.size() < n) {
            for (int[] connection : connections) {
                if (connection[1] == 0) {
                    canReachCapital.add(connection[0]);
                } else if (canReachCapital.contains(connection[0]) && !canReachCapital.contains(connection[1])) {
                    int temp = connection[0];
                    connection[0] = connection[1];
                    connection[1] = temp;
                    result++;
                }
                if (canReachCapital.contains(connection[1])) {
                    canReachCapital.add(connection[0]);
                }
            }
        }


        return result;
    }
}
