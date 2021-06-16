package com.interview.sde.algorithm.tree;

//https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
public class PreorderTraversal {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }


}
