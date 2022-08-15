package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp  = root.left;
        root.left = root.right;
        root.right = temp;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
