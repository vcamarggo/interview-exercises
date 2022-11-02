package com.interview.sde.java.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int start) {
        final Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<>(n);
        final int[] costFromStart = new int[n];
        Arrays.fill(costFromStart, Integer.MAX_VALUE);

        costFromStart[start - 1] = 0;

        for (int[] time : times) {
            adjacencyList.computeIfAbsent(time[0], k -> new HashMap<>()).put(time[1], time[2]);
        }

        //BellmanFord
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (Map.Entry<Integer, Integer> edge : adjacencyList.getOrDefault(i, new HashMap<>()).entrySet()) {
                    int newDistance = costFromStart[i - 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : costFromStart[i - 1] + edge.getValue();
                    if (newDistance < costFromStart[edge.getKey() - 1]) {
                        costFromStart[edge.getKey() - 1] = newDistance;
                    }
                }

            }
        }

        //Get the maximum distance from start node, which is the same as maximum delay
        int max = Arrays.stream(costFromStart).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
