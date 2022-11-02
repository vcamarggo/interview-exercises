package com.interview.sde.java.tree;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

}
