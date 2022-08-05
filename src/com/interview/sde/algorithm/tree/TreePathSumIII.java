package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/path-sum-iii/
public class TreePathSumIII {
    public static void main(String[] args) {
        System.out.println(new TreePathSumIII().pathSum(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))))), 3));
    }

    public int pathSum(TreeNode root, int targetSum) {
        int curCount = countPathSum(root, targetSum);
        if (root == null) {
            return 0;
        }

        return curCount + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int countPathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        long remainingTarget = targetSum - root.val;

        if (remainingTarget == 0) {
            count++;
        }

        return count + countPathSum(root.left, remainingTarget) + countPathSum(root.right, remainingTarget);
    }

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
}
