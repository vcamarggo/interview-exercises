package com.interview.sde.java.crackingcodeinterview;

import java.util.*;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
//https://www.hackerrank.com/challenges/bfsshortreach/problem
public class BFSShortestReachGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int executions = Integer.parseInt(scanner.nextLine());
        for (int w = 0; w < executions; w++) {
            HashMap<Integer, Node> graph = new HashMap<>();

            String[] verticesEdges = scanner.nextLine().split(" ");

            int vertices = Integer.parseInt(verticesEdges[0]);
            int edges = Integer.parseInt(verticesEdges[1]);

            for (int i = 1; i <= vertices; i++) {
                graph.put(i, new Node(i));
            }

            for (int i = 0; i < edges; i++) {
                String[] fromTo = scanner.nextLine().split(" ");
                int from = Integer.parseInt(fromTo[0]);
                int to = Integer.parseInt(fromTo[1]);
                graph.get(from).addEdge(to);
                graph.get(to).addEdge(from);
            }

            int startNode = Integer.parseInt(scanner.nextLine());
            int[] distances = new int[vertices + 1];

            Arrays.fill(distances, -1);
            distances[startNode] = 0;

            Queue<Node> processing = new LinkedList<>();
            processing.add(graph.get(startNode));
            HashSet<Integer> visited = new HashSet<>();

            while (!processing.isEmpty()) {
                Node node = processing.poll();
                for (Edge edge : node.edges) {
                    if (!visited.contains(edge.to)) {
                        processing.add(graph.get(edge.to));
                        distances[edge.to] = distances[node.id] + 6;
                        visited.add(edge.to);
                    }
                }
            }

            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= vertices; i++) {
                if (i != startNode) {
                    str.append(distances[i]);
                    str.append(" ");
                }
            }
            System.out.println(str);
        }
    }

    static class Node {
        int id;
        HashSet<Edge> edges;

        Node(int id) {
            this.id = id;
            this.edges = new HashSet<>();
        }

        void addEdge(int to) {
            edges.add(new Edge(id, to));
        }
    }

    private record Edge(int from, int to) {
    }
}
