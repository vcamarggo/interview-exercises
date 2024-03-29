package com.interview.sde.java.tree;

//https://leetcode.com/problems/path-sum/
public class TreePathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int targetSumNode = targetSum - root.data;

        //isLeafNode
        if (root.left == null && root.right == null) {
            return targetSumNode == 0;
        }

        return hasPathSum(root.left, targetSumNode) || hasPathSum(root.right, targetSumNode);
    }
}
