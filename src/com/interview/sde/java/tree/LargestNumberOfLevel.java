package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
public class LargestNumberOfLevel {

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

                max = Math.max(max, node.val);

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
