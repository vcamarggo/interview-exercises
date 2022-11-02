package com.interview.sde.java.graph;

import java.util.*;

//https://www.hackerrank.com/challenges/primsmstsub/problem
public class PrimMST {


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

    public static void main(String[] args) {
        System.out.println(prim(5, List.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 4),
                        List.of(4, 2, 6),
                        List.of(5, 2, 2),
                        List.of(2, 3, 5),
                        List.of(3, 5, 7)),
                1));
    }

    private static int prim(int n, List<List<Integer>> edgesL, int start) {
        final int[][] edges = new int[n + 1][n + 1];

        for (int[] edge : edges) {
            Arrays.fill(edge, -1);
        }

        for (List<Integer> e : edgesL) {
            edges[e.get(1)][e.get(0)] = e.get(2);
            edges[e.get(0)][e.get(1)] = e.get(2);
        }

        //QuickAccess to node
        Map<Integer, PrimNode> allNodes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 1; i < edges.length; i++) {
            PrimNode primNode = new PrimNode(i, Integer.MAX_VALUE, i);
            allNodes.put(primNode.id, primNode);
        }
        allNodes.get(1).weight -= 1;

        while (visited.size() != edges.length - 1) {

            PrimNode node = getMin(allNodes, visited);

            for (int i = 1; i < edges.length; i++) {
                if (allNodes.get(i).weight > edges[node.id][i] && edges[node.id][i] != -1 && !visited.contains(i)) {
                    allNodes.get(i).parent = node.id;
                    allNodes.get(i).weight = edges[node.id][i];
                }
            }
        }

        int sum = 0;
        for (int i = 2; i < edges.length; i++) {
            sum += edges[i][allNodes.get(i).parent];
        }
        return sum;
    }

    private static PrimNode getMin(Map<Integer, PrimNode> allNodes, Set<Integer> processed) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < allNodes.size() + 1; v++)
            if (!processed.contains(v) && allNodes.get(v).weight < min) {
                min = allNodes.get(v).weight;
                min_index = v;
            }
        PrimNode primNode = allNodes.get(min_index);
        processed.add(primNode.id);

        return primNode;
    }

}
