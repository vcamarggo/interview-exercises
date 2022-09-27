package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/maximum-binary-tree/
//a.k.a. Cartesian Tree
public class MaximumBinaryTree {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = start;
        int maxValue = nums[start];
        for (int i = start; i <= end; i++) {
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return new TreeNode(maxValue, constructMaximumBinaryTree(nums, start, maxIndex - 1), constructMaximumBinaryTree(nums, maxIndex + 1, end));
    }
}
