package com.interview.sde.java.tree;

//https://leetcode.com/problems/subtree-of-another-tree/
public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (subRoot == null) {
            return true;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (subRoot == null || root == null || subRoot.val != root.val) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }


}
