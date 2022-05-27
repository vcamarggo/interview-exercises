package com.interview.sde.algorithm.graph;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-center-of-star-graph/
public class FindStartGraph {
    int findCenter(int[][] edges) {

        Map<Integer, Integer> edgeCounter = new HashMap<>();
        for (int[] edge : edges) {
            int edgeA = edge[0];
            int edgeB = edge[1];
            edgeCounter.put(edgeA, edgeCounter.getOrDefault(edgeA, 0) + 1);
            edgeCounter.put(edgeB, edgeCounter.getOrDefault(edgeB, 0) + 1);
        }
         for (Map.Entry<Integer, Integer> entry : edgeCounter.entrySet()){
            if(entry.getValue() == edgeCounter.size() - 1){
                return entry.getValue();
            }
        }

        return -1;
    }
}
