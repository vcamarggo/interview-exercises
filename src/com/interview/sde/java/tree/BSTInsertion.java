package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
public class BSTInsertion {
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
