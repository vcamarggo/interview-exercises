package com.interview.sde.hackerrank.java.advanced;

import java.util.*;

public class IsBST {
    boolean checkBST(InsertBST.Node root) {
        return checkInternal(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkInternal(InsertBST.Node root, int min, int max) {
        return root == null || (root.data > min && root.data < max && checkInternal(root.left, min, root.data) && checkInternal(root.right, root.data, max));
    }
}
