package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeaves(root1).equals(getLeaves(root2));
    }

    private List<Integer> getLeaves(TreeNode root) {
        return getLeaves(root, new ArrayList<>());
    }

    private List<Integer> getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return leaves;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            getLeaves(root.left, leaves);
            getLeaves(root.right, leaves);
        }

        return leaves;
    }
}
