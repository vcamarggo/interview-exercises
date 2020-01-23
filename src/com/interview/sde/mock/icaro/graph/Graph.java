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

    static class Node implements Cloneable {
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

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, Node> nodesMapping = new HashMap<>();

        String[] gameSize = scanner.nextLine().split(" ");
        //int vertex = Integer.parseInt(gameSize[0]);
        int edges = Integer.parseInt(gameSize[1]);

        String[] startEnd = scanner.nextLine().split(" ");
        int startId = Integer.parseInt(startEnd[0]);
        int endId = Integer.parseInt(startEnd[1]);


        for (String nodeIdString : scanner.nextLine().split(" ")) {
            int nodeId = Integer.parseInt(nodeIdString);
            Node node1 = new Node(nodeId);
            nodesMapping.put(nodeId, node1);
        }

        for (int i = 0; i < edges; i++) {
            String[] edgeData = scanner.nextLine().split(" ");

            int node1Id = Integer.parseInt(edgeData[0]);
            int node2Id = Integer.parseInt(edgeData[1]);

            Node node1 = nodesMapping.get(node1Id);
            node1.addEdge(new Edge(node1Id, node2Id, Integer.parseInt(edgeData[2])));
            nodesMapping.put(node1Id, node1);
        }

        Node startNode = nodesMapping.get(startId);
        startNode.weight = 0;

        dijkstra(cloneNodes(nodesMapping), startId, endId);

        bellmanFord(cloneNodes(nodesMapping), startId, endId);
    }

    private static HashMap<Integer, Node> cloneNodes(HashMap<Integer, Node> nodesMapping) throws CloneNotSupportedException {
        HashMap<Integer, Node> clones = new HashMap<>();
        for (Node node : nodesMapping.values()) {
            clones.put(node.nodeId, (Node) node.clone());
        }
        return clones;
    }

    private static void dijkstra(HashMap<Integer, Node> nodes, int startId, int endId) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Node startNode = nodes.get(startId);
        queue.add(startNode);

        while (!queue.isEmpty() && queue.peek().nodeId != endId) {
            Node processingNode = queue.poll();
            for (Edge edge : processingNode.edges) {
                Node nodeTo = nodes.get(edge.to);
                if (nodeTo.weight > processingNode.weight + edge.weight && processingNode.weight != Integer.MAX_VALUE) {
                    nodeTo.setWeight(processingNode.weight + edge.weight);
                    queue.add(nodeTo);
                }
            }
        }
        System.out.println(nodes.get(endId).toString());
    }

    private static void bellmanFord(HashMap<Integer, Node> nodes, int startId, int endId) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            for (Node node : nodes.values()) {
                for (Edge edge : node.edges) {
                    Node nodeTo = nodes.get(edge.to);
                    if (nodeTo.weight > node.weight + edge.weight && node.weight != Integer.MAX_VALUE) {
                        nodeTo.setWeight(node.weight + edge.weight);
                    }
                }
            }
        }
        System.out.println(nodes.get(endId).toString());
    }
}
