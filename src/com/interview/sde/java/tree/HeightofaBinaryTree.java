package com.interview.sde.java.tree;

//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
public class HeightofaBinaryTree {

    public static int height(Node root) {
        return root == null
                ? -1
                : Math.max(height(root.left) + 1, height(root.right) + 1);
    }

    class Node {
        int data;
        Node left;
        Node right;
    }


}
