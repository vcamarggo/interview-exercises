package com.interview.sde.mock.icaro.graph;

import java.util.*;

public class Graph {

    static class Edge {
        int weight;
        int from;
        int to;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int nodeId;
        int weight;
        HashSet<Edge> edges;

        Node(int nodeId) {
            this.nodeId = nodeId;
            this.weight = Integer.MAX_VALUE;
            this.edges = new HashSet<>();
        }

        public void setWeight(int min) {
            this.weight = min;
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "nodeId=" + nodeId +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Node> nodeMinWeightMapping = new HashMap<>();

        String[] gameSize = scanner.nextLine().split(" ");
        //int vertex = Integer.parseInt(gameSize[0]);
        int edges = Integer.parseInt(gameSize[1]);

        String[] startEnd = scanner.nextLine().split(" ");
        int startId = Integer.parseInt(startEnd[0]);
        int endId = Integer.parseInt(startEnd[1]);


        for (String nodeIdString : scanner.nextLine().split(" ")) {
            int nodeId = Integer.parseInt(nodeIdString);
            Node node1 = new Node(nodeId);
            nodeMinWeightMapping.put(nodeId, node1);
        }

        for (int i = 0; i < edges; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);

            Node node1 = nodeMinWeightMapping.get(node1Id);
            node1.addEdge(new Edge(node1Id, node2Id, Integer.parseInt(edgeData[2])));
            nodeMinWeightMapping.put(node1Id, node1);
        }

        dijkstra(nodeMinWeightMapping, startId, endId);
    }

    private static void dijkstra(HashMap<Integer, Node> nodes, int startId, int endId) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        Node startNode = nodes.get(startId);
        startNode.weight = 0;

        queue.add(startNode);

        while (!queue.isEmpty() && queue.peek().nodeId != endId) {
            Node processingNode = queue.poll();
            for (Edge edge : processingNode.edges) {
                Node nodeTo = nodes.get(edge.to);
                if (nodeTo.weight > processingNode.weight + edge.weight) {
                    nodeTo.setWeight(processingNode.weight + edge.weight);
                    queue.add(nodeTo);
                }
            }
        }
        System.out.println(nodes.get(endId).toString());
    }
}
