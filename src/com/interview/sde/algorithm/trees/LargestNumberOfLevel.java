package com.interview.sde.algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
public class LargestNumberOfLevel {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> solution = new ArrayList<>();

        if (root == null) {
            return solution;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            int nodeToProcess = queue.size();
            int max = Integer.MIN_VALUE;

            while (nodeToProcess > 0) {
                TreeNode node = queue.poll();

                max = Math.max(max, node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                nodeToProcess--;
            }

            solution.add(max);
        }

        return solution;
    }
}
