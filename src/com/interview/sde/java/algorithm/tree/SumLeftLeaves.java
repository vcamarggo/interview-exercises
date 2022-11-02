package com.interview.sde.algorithm.tree;

public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeftLeaf) {
        return root == null ? 0 : root.left == null && root.right == null ? isLeftLeaf ? root.val : 0 : sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }


}
