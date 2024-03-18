package com.interview.sde.java.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TopologicalOrder {


    static int postNumber = 1;
    static Set<Integer> visiting = new HashSet<>();
    static Set<Integer> visited = new HashSet<>();
    static boolean[][] edges;
    static int[] postOrderNumber;
    static boolean foundLoop;


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
            if (!visited.contains(node) && !visiting.contains(node)) {
                dfs(node);
            }
        }
        if (foundLoop) {
            System.out.println("No solution");
            return;
        }

        // Fancy O(n) version
        int[] topologicalOrder = new int[postOrderNumber.length * 2];
        Arrays.fill(topologicalOrder, -1);

        for (int i = 0; i < postOrderNumber.length; i++) {
            topologicalOrder[postOrderNumber[i]] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = topologicalOrder.length - 1; i >= 0; i--) {
            if (topologicalOrder[i] != -1) {
                sb.append(topologicalOrder[i]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }


    private static void dfs(int node) {

        postNumber++;
        visiting.add(node);
        for (int destination = 1; destination < edges.length && !foundLoop; destination++) {
            if (edges[node][destination]) {
                if (visiting.contains(destination)) {
                    foundLoop = true;
                } else if (!visited.contains(destination)) {
                    dfs(destination);
                }
            }
        }
        visiting.remove(node);
        visited.add(node);
        postOrderNumber[node] = postNumber++;
    }
}
