package com.interview.sde.algorithm.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//To design this I opted to not pass parameters all around. It's clearly overusing static attributes
public class SccTopologicalOrder {


    static int postNumber = 1;
    static int sccId = 0;
    static Set<Integer> visited = new HashSet<>();
    static boolean[][] edges;
    static boolean[][] reverseEdges;
    static int[] postOrderNumber;
    static int[] scc;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        edges = new boolean[vertex + 1][vertex + 1];
        reverseEdges = new boolean[vertex + 1][vertex + 1];
        postOrderNumber = new int[vertex + 1];
        scc = new int[vertex + 1];

        //Start end ignored
        String[] startEnd = scanner.nextLine().split(" ");

        //nodes ID ignored
        scanner.nextLine();

        for (int i = 0; i < edgesNumber; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);
            edges[node1Id][node2Id] = true;
            reverseEdges[node2Id][node1Id] = true;
        }

        int sccNumber = sccCounter();

        StringBuilder output = new StringBuilder("Topological ordering of the scc:\n");
        for (int i = sccNumber; i > 0; i--) {
            output.append(sccNumber - i + 1).append("th scc: ");
            for (int j = 1; j < scc.length; j++) {
                if (scc[j] == i) {
                    output.append(j).append(" ");
                }
            }
            output.append("\n");
        }

        System.out.println(output);

    }

    private static int sccCounter() {

        for (int node = 1; node < reverseEdges.length; node++) {
            if (!visited.contains(node)) {
                explore(node, reverseEdges);
            }
        }

        // Fancy O(n) version for ordering based on dfs post order number
        int[] topologicalOrder = new int[postOrderNumber.length * 2];
        for (int i = 1; i < postOrderNumber.length; i++) {
            topologicalOrder[postOrderNumber[i]] = i;
        }

        visited.clear();

        for (int i = topologicalOrder.length - 1; i >= 0; i--) {
            int node = topologicalOrder[i];
            if (node != 0 && !visited.contains(node)) {
                scc[node] = sccId++;
                explore(node, edges);
            }
        }
        return (int) Arrays.stream(scc).filter(i -> i != 0).distinct().count();
    }

    private static void explore(int node, boolean[][] graph) {
        postNumber++;
        visited.add(node);
        scc[node] = sccId;
        for (int destination = 1; destination < graph.length; destination++) {
            if (graph[node][destination] && !visited.contains(destination)) {
                explore(destination, graph);
            }
        }
        postOrderNumber[node] = postNumber++;
    }
}
