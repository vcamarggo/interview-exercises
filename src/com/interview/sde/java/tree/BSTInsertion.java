package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
public class BSTInsertion {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
