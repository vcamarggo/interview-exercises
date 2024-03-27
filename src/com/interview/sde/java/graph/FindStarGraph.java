package com.interview.sde.java.graph;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-center-of-star-graph/
public class FindStarGraph {
    int findCenter(int[][] edges) {

        Map<Integer, Integer> edgeCounter = new HashMap<>();
        for (int[] edge : edges) {
            int edgeA = edge[0];
            int edgeB = edge[1];
            edgeCounter.compute(edgeA, (k, v) -> v == null ? 1 : v + 1);
            edgeCounter.compute(edgeB, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> entry : edgeCounter.entrySet()) {
            if (entry.getValue() == edgeCounter.size() - 1) {
                return entry.getValue();
            }
        }

        return -1;
    }
}
