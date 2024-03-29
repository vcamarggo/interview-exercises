package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
public class PreorderTraversal {
    public static void preOrder(TreeNode root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

}
