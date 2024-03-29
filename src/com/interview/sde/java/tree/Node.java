package com.interview.sde.java.tree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
