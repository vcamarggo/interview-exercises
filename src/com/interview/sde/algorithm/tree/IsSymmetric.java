package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/symmetric-tree/
public class IsSymmetric {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public boolean isSymmetric(BSTInsertion.Node root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(BSTInsertion.Node left, BSTInsertion.Node right) {
        boolean leftIsNull = left == null;
        boolean rightIsNull = right == null;

        //Not a great implementation, I was playing with boolean condition and algebra simplification to keep it in one line
        return (leftIsNull && rightIsNull) ||
                (
                        !leftIsNull &&
                                !rightIsNull &&
                                left.data == right.data &&
                                isSymmetric(left.left, right.right) &&
                                isSymmetric(left.right, right.left)
                );
    }
}