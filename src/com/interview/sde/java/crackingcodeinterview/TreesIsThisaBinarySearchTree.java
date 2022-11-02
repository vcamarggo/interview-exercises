package com.interview.sde.java.crackingcodeinterview;

//https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
public class TreesIsThisaBinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkInternal(Node root, int smallest, int largest) {
        return (root.left.data < root.data && smallest < root.left.data && root.left.data < largest
                && checkInternal(root.left, smallest, root.data))
                &&
                (root.right.data > root.data && smallest < root.right.data && root.right.data < largest
                        && checkInternal(root.right, root.data, largest));
    }

    boolean checkBST(Node root) {
        int largest = Integer.MAX_VALUE;
        int smallest = Integer.MIN_VALUE;
        return checkInternal(root, smallest, largest);
    }
}
