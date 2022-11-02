package com.interview.sde.java.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxLevel = 1;
        int maxSum = root.val;
        int currentLevel = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelSum = 0;

            while (size-- > 0) {
                TreeNode node = queue.poll();

                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                levelSum += node.val;
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;
        }

        return maxLevel;
    }


}
