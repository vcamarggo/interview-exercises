package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearchCreateTree(nums, 0, nums.length - 1);
    }

    public TreeNode binarySearchCreateTree(int[] nums, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (end + start) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = binarySearchCreateTree(nums, start, mid - 1);
        root.right = binarySearchCreateTree(nums, mid + 1, end);
        return root;
    }
}
