package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinDepthLeaf {
    public int minDepth(TreeNode root) {
        return minDepth(root, 1);
    }

    //Run per level and check first leaf would be faster than scan all
    int minDepth(TreeNode root, int currentLevel) {
        if (root == null) {
            return currentLevel == 1 ? 0 : Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return currentLevel;
        }

        return Math.min(minDepth(root.left, currentLevel + 1), minDepth(root.right, currentLevel + 1));
    }

}
