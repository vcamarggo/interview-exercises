package com.interview.sde.algorithm.trees;

//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
public class HeightofaBinaryTree {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public static int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }

    }


}
