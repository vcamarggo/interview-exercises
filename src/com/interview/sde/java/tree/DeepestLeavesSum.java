package com.interview.sde.java.tree;

//https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int deepestNode = height(root);
        return deepestLeavesSum(root, 1, deepestNode);
    }

    int deepestLeavesSum(TreeNode root, int height, int maxHeight) {
        return root == null
                ? 0
                : root.left == null && root.right == null && height == maxHeight
                ? root.val
                : deepestLeavesSum(root.left, height + 1, maxHeight) + deepestLeavesSum(root.right, height + 1, maxHeight);
    }

    int height(TreeNode root) {
        return root == null
                ? 0
                : Math.max(height(root.left), height(root.right)) + 1;
    }

}
