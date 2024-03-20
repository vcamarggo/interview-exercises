package com.interview.sde.java.tree;

//https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.left != null)
            root.left = trimBST(root.left, low, high);
        if (root.right != null)
            root.right = trimBST(root.right, low, high);

        if (root.val < low) {
            root = root.right;
        } else if (root.val > high) {
            root = root.left;
        }

        return root;
    }
}
