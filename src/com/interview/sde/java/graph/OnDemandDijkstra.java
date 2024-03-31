package com.interview.sde.java.graph;

import java.util.*;

//https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
public class OnDemandDijkstra {

    private static final int NODE_FIELD = 0;
    private static final int COST_FIELD = 1;
    int n;
    Map<Integer, Map<Integer, Integer>> edges;


    public OnDemandDijkstra(int n, int[][] edges) {
        this.n = n;
        this.edges = new HashMap<>(n);
        for (int[] edge : edges) {
            this.edges.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
        }
    }

    public void addEdge(int[] edge) {
        this.edges.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
    }

    public int shortestPath(int startId, int endId) {
        final int initialDistance = 0;

        int[] nodesDistance = new int[n];
        Arrays.fill(nodesDistance, Integer.MAX_VALUE);
        nodesDistance[startId] = initialDistance;

        PriorityQueue<int[]> nodesToProcess = new PriorityQueue<>(Comparator.comparingInt(o -> o[COST_FIELD]));
        nodesToProcess.add(new int[]{startId, initialDistance});

        while (!nodesToProcess.isEmpty()) {
            int currentNode = nodesToProcess.poll()[NODE_FIELD];

            for (Map.Entry<Integer, Integer> edge : edges.getOrDefault(currentNode, new HashMap<>()).entrySet()) {
                int newDistance = nodesDistance[currentNode] == Integer.MAX_VALUE ? Integer.MAX_VALUE : nodesDistance[currentNode] + edge.getValue();
                if (newDistance < nodesDistance[edge.getKey()]) {
                    nodesDistance[edge.getKey()] = newDistance;
                    nodesToProcess.add(new int[]{edge.getKey(), newDistance});
                }
            }
        }
        return nodesDistance[endId] == Integer.MAX_VALUE ? -1 : nodesDistance[endId];
    }
}
