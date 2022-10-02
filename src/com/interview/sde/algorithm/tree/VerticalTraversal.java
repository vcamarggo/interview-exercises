package com.interview.sde.algorithm.tree;

import java.util.*;

public class VerticalTraversal {


    private static final int VALUE_INDEX = 1;
    private static final int ROW_INDEX = 0;
    private final Comparator<int[]> compareAscRowThenAscValue = (o1, o2) -> {
        int diff = Integer.compare(o1[ROW_INDEX], o2[ROW_INDEX]);
        if (diff == 0) {
            return Integer.compare(o1[VALUE_INDEX], o2[VALUE_INDEX]);
        }
        return diff;
    };
    //Storing row number [0] and value [1]. Row is necessary for ordering;
    Map<Integer, PriorityQueue<int[]>> mapper = new TreeMap<>();

    public static void main(String[] args) {
        new VerticalTraversal().verticalTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))));
        new VerticalTraversal().verticalTraversal(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(4, new TreeNode(2), null)));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        populateMapper(root, 0, 0);
        List<List<Integer>> solution = new ArrayList<>();
        for (PriorityQueue<int[]> pq : mapper.values()) {
            List<Integer> subSolution = new ArrayList<>(pq.size());
            while (!pq.isEmpty()) {
                int[] data = pq.poll();
                subSolution.add(data[VALUE_INDEX]);
            }
            solution.add(subSolution);
        }
        return solution;
    }

    private void populateMapper(TreeNode root, int row, int column) {

        if (root != null) {
            mapper.computeIfAbsent(column, k -> new PriorityQueue<>(compareAscRowThenAscValue)).add(new int[]{row, root.val});
            populateMapper(root.left, row + 1, column - 1);
            populateMapper(root.right, row + 1, column + 1);
        }
    }


}
