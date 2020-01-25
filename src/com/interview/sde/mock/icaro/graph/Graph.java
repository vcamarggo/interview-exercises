package com.interview.sde.mock.icaro.graph;

import java.util.*;

//Implementation of Dijkstra//BellmanFord//FloydWarshall algorithms for search in Graphs
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
        int vertex = Integer.parseInt(gameSize[0]);
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

        System.out.println("From: " + startId + " - To: " + endId);

        dijkstra(cloneNodes(nodesMapping), startId, endId);

        bellmanFord(cloneNodes(nodesMapping), startId, endId);

        floydWarshall(cloneNodes(nodesMapping), startId, endId);
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
        startNode.weight = 0;
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
        System.out.println("Dijkstra " + nodes.get(endId).weight);
    }

    private static void bellmanFord(HashMap<Integer, Node> nodes, int startId, int endId) {
        Node startNode = nodes.get(startId);
        startNode.weight = 0;
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
        System.out.println("BellmanFord " + nodes.get(endId).weight);
    }

    private static void floydWarshall(HashMap<Integer, Node> nodes, int startId, int endId) {

        int[][] matrixPrev = initMatrixFloydWarshall(nodes);
        int size = matrixPrev.length;
        int[][] matrixK = new int[size][size];

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int ikValue = matrixPrev[i][k];
                    int jkValue = matrixPrev[k][j];
                    if (ikValue == Integer.MAX_VALUE || jkValue == Integer.MAX_VALUE) {
                        matrixK[i][j] = matrixPrev[i][j];
                    } else {
                        matrixK[i][j] = Math.min(matrixPrev[i][j], ikValue + jkValue);
                    }
                }
            }
            matrixPrev = matrixK;
        }

        System.out.println("FloydWarshall " + matrixK[startId - 1][endId - 1]);
        for (int[] row : matrixK)
            System.out.println(Arrays.toString(row));
    }

    private static int[][] initMatrixFloydWarshall(HashMap<Integer, Node> nodes) {
        int size = Collections.max(nodes.values(), Comparator.comparingInt(o -> o.nodeId)).nodeId;
        int[][] matrixPrev = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixPrev[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (Node node : nodes.values()) {
            for (Edge edge : node.edges) {
                matrixPrev[edge.from - 1][edge.to - 1] = edge.weight;
            }
        }
        return matrixPrev;
    }
}
