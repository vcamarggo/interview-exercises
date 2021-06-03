package com.interview.sde.algorithm.trees;

//https://www.hackerrank.com/challenges/tree-inorder-traversal/problem
public class InorderTraversal {
    class Node {
        int data;
        Node left;
        Node right;
    }

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
