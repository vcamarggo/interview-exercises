package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(5, null,
                        new TreeNode(6)));
        flatten(root);
        System.out.println(root.val);
    }

    static void flatten(TreeNode root) {

        if (root != null) {
            if (root.left != null) {
                flatten(root.left);
            }

            if (root.left != null) {
                TreeNode rightmostOfLeft = findRightmost(root.left);
                rightmostOfLeft.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            if (root.right != null) {
                flatten(root.right);
            }
        }
    }

    static TreeNode findRightmost(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
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
