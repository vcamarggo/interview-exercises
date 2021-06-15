package com.interview.sde.algorithm.graph;

import java.util.*;

//Implementation of BiDijkstra algorithm for search in Graphs
//Based on the lecture https://www.coursera.org/lecture/algorithms-on-graphs/finding-shortest-path-after-meeting-in-the-middle-l8qtA

// Suppressed due to independent files in this package
@SuppressWarnings("DuplicatedCode")
public class BiDijkstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        int[][] edges = new int[vertex + 1][vertex + 1];
        int[] nodesDistance = new int[vertex + 1];


        int[][] edgesReverse = new int[vertex + 1][vertex + 1];
        int[] nodesDistanceReverse = new int[vertex + 1];

        Arrays.fill(nodesDistance, Integer.MAX_VALUE);
        Arrays.fill(nodesDistanceReverse, Integer.MAX_VALUE);


        String[] startEnd = scanner.nextLine().split(" ");
        int startId = Integer.parseInt(startEnd[0]);
        int endId = Integer.parseInt(startEnd[1]);

        //nodes ID ignored
        scanner.nextLine();

        for (int i = 0; i < edgesNumber; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);

            edges[node1Id][node2Id] = Integer.parseInt(edgeData[2]);

            edgesReverse[node2Id][node1Id] = edges[node1Id][node2Id];

        }

        System.out.println("From: " + startId + " - To: " + endId);

        bidijkstra(nodesDistance, nodesDistanceReverse, edges, edgesReverse, startId, endId);
    }

    private static void bidijkstra(int[] nodesDistanceFromStart, int[] nodesDistanceFromEnd, int[][] edges, int[][] edgesReversed, int startId, int endId) {
        PriorityQueue<Integer> nodesToProcessFromStart = new PriorityQueue<>(Comparator.comparingInt(o -> nodesDistanceFromStart[o]));
        Set<Integer> processedNodesFromStart = new HashSet<>();
        nodesDistanceFromStart[startId] = 0;
        nodesToProcessFromStart.add(startId);

        PriorityQueue<Integer> nodesToProcessFromEnd = new PriorityQueue<>(Comparator.comparingInt(o -> nodesDistanceFromEnd[o]));
        Set<Integer> processedNodesFromEnd = new HashSet<>();
        nodesDistanceFromEnd[endId] = 0;
        nodesToProcessFromEnd.add(endId);

        int solution = -1;

        while (!nodesToProcessFromStart.isEmpty() || !nodesToProcessFromEnd.isEmpty()) {

            if (searchCommonNodeInNeighborhood(nodesToProcessFromStart, edges, nodesDistanceFromStart, processedNodesFromStart, processedNodesFromEnd)) {
                solution = findSolution(nodesDistanceFromStart, nodesDistanceFromEnd);
                break;
            }

            if (searchCommonNodeInNeighborhood(nodesToProcessFromEnd, edgesReversed, nodesDistanceFromEnd, processedNodesFromEnd, processedNodesFromStart)) {
                solution = findSolution(nodesDistanceFromStart, nodesDistanceFromEnd);
                break;
            }
        }
        System.out.println("Dijkstra " + solution);
    }

    private static Integer findSolution(int[] nodesDistanceFromStart, int[] nodesDistanceFromEnd) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nodesDistanceFromStart.length; i++) {
            long distance = (long) nodesDistanceFromStart[i] + nodesDistanceFromEnd[i];
            if (distance < min) {
                min = (int) distance;
            }
        }

        return min;
    }

    public static boolean searchCommonNodeInNeighborhood(PriorityQueue<Integer> nodes, final int[][] edges, int[] nodesDistance, Set<Integer> processed, Set<Integer> processedReverseSide) {
        if (!nodes.isEmpty()) {
            int node = nodes.poll();
            processed.add(node);

            if (processedReverseSide.contains(node)) {
                return true;
            }

            for (int i = 1; i < edges[node].length; i++) {
                if (edges[node][i] != 0) {
                    int newDistance = nodesDistance[node] == Integer.MAX_VALUE ? Integer.MAX_VALUE : nodesDistance[node] + edges[node][i];
                    if (newDistance < nodesDistance[i]) {
                        nodesDistance[i] = newDistance;
                        nodes.add(i);
                    }
                }
            }
        }

        return false;
    }


}
