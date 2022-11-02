package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/is-binary-search-tree/problem
public class IsThisaBinarySearchTree {
    boolean checkBST(Node root) {
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    boolean checkBSTHelper(Node root, int low, int high) {
        if (root == null) {
            return true;
        }
        return root.data < high && root.data > low && checkBSTHelper(root.left, low, root.data)
                && checkBSTHelper(root.right, root.data, high);
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
