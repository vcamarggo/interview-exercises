package com.interview.sde.algorithm.graph;

import java.util.*;

//Implementation of Kruskal's algorithm for generating MST
public class MST {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] gameSize = scanner.nextLine().split(" ");
        int vertex = Integer.parseInt(gameSize[0]);
        int edgesNumber = Integer.parseInt(gameSize[1]);

        int[][] edges = new int[vertex + 1][vertex + 1];

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
            edges[node2Id][node1Id] = Integer.parseInt(edgeData[2]);
        }

        kruskal(edges);
        System.out.println();
        prim(edges);
    }

    private static void kruskal(final int[][] edges) {
        PriorityQueue<int[]> edgesToProcess = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[2]));
        ArrayList<int[]> solution = new ArrayList<>();
        int[] parents = new int[edges.length];


        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;

            for (int j = i + 1; j < edges[0].length; j++) {
                if (edges[i][j] != 0) {
                    edgesToProcess.add(new int[]{i, j, edges[i][j]});
                }
            }
        }

        while (solution.size() != edges.length - 2) {
            int[] edge = edgesToProcess.poll();

            //No cycle created
            if (findParent(parents, edge[0]) != findParent(parents, edge[1])) {
                union(parents, edge[0], edge[1]);
                solution.add(edge);
            }
        }

        System.out.println("Kruskal solution:");
        for (int[] edge : solution) {
            System.out.println(String.format("Edge %02d <-> %02d - weight %s", edge[0], edge[1], edge[2]));
        }
    }

    static class PrimNode {
        public int parent;
        int id;
        int weight;

        public PrimNode(int id, int weight, int parent) {
            this.id = id;
            this.weight = weight;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PrimNode primNode = (PrimNode) o;
            return id == primNode.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    private static void prim(final int[][] edges) {
        //QuickAccess to node
        Map<Integer, PrimNode> allNodes = new HashMap<>();
        Map<Integer, PrimNode> solution = new HashMap();

        boolean[] processed = new boolean[edges.length];

        for (int i = 1; i < edges.length; i++) {
            PrimNode primNode = new PrimNode(i, Integer.MAX_VALUE, i);
            allNodes.put(primNode.id, primNode);
        }
        allNodes.get(1).weight -=1;

        while (solution.size() != edges.length - 1) {

            PrimNode node = getMin(allNodes, processed);
            solution.put(node.id, node);

            for (int i = 1; i < edges.length; i++) {
                if (allNodes.get(i).weight > edges[node.id][i] && edges[node.id][i] != 0 && !solution.containsKey(i)) {
                    allNodes.get(i).parent = node.id;
                    allNodes.get(i).weight = edges[node.id][i];
                }
            }
        }

        System.out.println("Prim solution:");
        for (int i = 2; i < edges.length; i++) {
            System.out.println(String.format("Edge %02d <-> %02d - weight %s", solution.get(i).parent, i, edges[i][solution.get(i).parent]));
        }

    }

    private static PrimNode getMin(Map<Integer, PrimNode> allNodes, boolean[] processed) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < processed.length; v++)
            if (!processed[v] && allNodes.get(v).weight < min) {
                min = allNodes.get(v).weight;
                min_index = v;
            }

        processed[min_index] = true;
        return allNodes.get(min_index);
    }

    public static void union(int[] parents, int a, int b) {
        int aParent = findParent(parents, a);
        int bParent = findParent(parents, b);
        if (aParent != bParent) {
            int min = Math.min(aParent, bParent);
            int max = Math.max(aParent, bParent);
            parents[min] = parents[max];
        }
    }

    private static int findParent(int[] parents, int i) {
        while (i != parents[i]) {
            i = parents[i];
        }
        return i;
    }

}
