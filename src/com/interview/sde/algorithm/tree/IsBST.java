package com.interview.sde.algorithm.tree;

public class IsBST {
    boolean checkBST(InsertBST.Node root) {
        return checkInternal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean checkInternal(InsertBST.Node root, long min, long max) {
        return root == null || (root.data > min && root.data < max && checkInternal(root.left, min, root.data) && checkInternal(root.right, root.data, max));
    }
}
