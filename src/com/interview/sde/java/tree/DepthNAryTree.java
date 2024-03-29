package com.interview.sde.java.tree;

import java.util.List;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class DepthNAryTree {
    public int maxDepth(NAryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        for (NAryTreeNode child : root.children) {
            max = Math.max(max, maxDepth(child) + 1);
        }
        return max;
    }

}
