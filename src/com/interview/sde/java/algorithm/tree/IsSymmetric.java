package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/symmetric-tree/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        boolean leftIsNull = left == null;
        boolean rightIsNull = right == null;

        //Not a great implementation, I was playing with boolean condition and algebra simplification to keep it in one line
        return (leftIsNull && rightIsNull) ||
                (
                        !leftIsNull &&
                                !rightIsNull &&
                                left.val == right.val &&
                                isSymmetric(left.left, right.right) &&
                                isSymmetric(left.right, right.left)
                );
    }
}
