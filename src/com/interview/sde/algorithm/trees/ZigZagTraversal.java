package com.interview.sde.algorithm.trees;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
public class ZigZagTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();

        if (root == null) return solution;

        int level = 0;
        Deque<TreeNode> toProcess = new LinkedList<>();
        Queue<TreeNode> nextToProcess = new LinkedList<>();

        toProcess.add(root);
        nextToProcess.add(root);

        while (!toProcess.isEmpty()) {
            int remaining = toProcess.size();

            List<Integer> levelSolution = new ArrayList<>();

            while (remaining-- > 0) {
                TreeNode node = level % 2 == 0 ? toProcess.pollFirst() : toProcess.pollLast();

                TreeNode nodeToProcess = nextToProcess.poll();
                if (nodeToProcess.left != null)
                    nextToProcess.add(nodeToProcess.left);
                if (nodeToProcess.right != null)
                    nextToProcess.add(nodeToProcess.right);

                levelSolution.add(node.val);
            }
            toProcess.addAll(nextToProcess);
            solution.add(levelSolution);
            level++;
        }
        return solution;
    }

    public static void main(String[] args) {

        TreeNode leftLeft = new TreeNode(4);
        TreeNode left = new TreeNode(2, leftLeft, null);

        TreeNode rightRight = new TreeNode(5);
        TreeNode right = new TreeNode(3, null, rightRight);

        TreeNode root = new TreeNode(1, left, right);

        zigzagLevelOrder(root);
    }
}
