package com.interview.sde.java.tree;

//https://leetcode.com/problems/validate-binary-search-tree/
//https://www.hackerrank.com/challenges/is-binary-search-tree/problem

public class IsBST {
    boolean checkBST(Node root) {
        return checkInternal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkInternal(Node root, long min, long max) {
        return root == null || (root.data > min && root.data < max && checkInternal(root.left, min, root.data) && checkInternal(root.right, root.data, max));
    }
}
