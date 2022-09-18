package com.interview.sde.algorithm.tree;

public class SumLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeftLeaf) {
        return root == null ? 0 : root.left == null && root.right == null ? isLeftLeaf ? root.val : 0 : sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
