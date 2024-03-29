package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/tree-inorder-traversal/problem
public class InorderTraversal {
    public static void inOrder(Node root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrder(root.right);
        }
    }

}
