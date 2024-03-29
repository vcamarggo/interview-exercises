package com.interview.sde.java.tree;

public class TreeNode {
    public int val;
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.data = val;
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
