package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
public class PostorderTraversal {
    public static void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
}
