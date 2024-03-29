package com.interview.sde.java.tree;

//https://leetcode.com/problems/balanced-binary-tree/
public class isBalancedTree {

    boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }

}
