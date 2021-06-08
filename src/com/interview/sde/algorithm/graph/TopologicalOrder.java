package com.interview.sde.algorithm.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TopologicalOrder {


    static int postNumber = 1;
    static Set<Integer> visited = new HashSet<>();
    static boolean[][] edges;
    static int[] postOrderNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        edges = new boolean[vertex + 1][vertex + 1];
        postOrderNumber = new int[vertex + 1];

        //Start end ignored
        String[] startEnd = scanner.nextLine().split(" ");

        //nodes ID ignored
        scanner.nextLine();

        for (int i = 0; i < edgesNumber; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);
            edges[node1Id][node2Id] = true;
        }

        topologicalOrder(edges);

    }

    private static void topologicalOrder(boolean[][] edges) {

        for (int node = 1; node < edges.length; node++) {
            if (!visited.contains(node)) {
                explore(node);
            }
        }

        // Fancy O(n) version
        int[] topologicalOrder = new int[postOrderNumber.length * 2];
        for (int i = 1; i < postOrderNumber.length; i++) {
            topologicalOrder[postOrderNumber[i]] = i;
        }

        for (int i = topologicalOrder.length - 1; i >= 0; i--) {
            if (topologicalOrder[i] != 0) {
                System.out.println(topologicalOrder[i]);
            }
        }
    }


    private static void explore(int node) {
        postNumber++;
        visited.add(node);
        for (int destination = 1; destination < edges.length; destination++) {
            if (edges[node][destination] && !visited.contains(destination)) {
                explore(destination);
            }
        }
        postOrderNumber[node] = postNumber++;
    }
}
