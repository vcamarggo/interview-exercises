package com.interview.sde.algorithm.trees;

//https://leetcode.com/problems/symmetric-tree/
public class isSymmetric {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public boolean isSymmetric(BSTInsertion.Node root) {
            return isSymmetric(root, root);
        }
        public boolean isSymmetric(BSTInsertion.Node rl, BSTInsertion.Node rr) {
            boolean leftIsNull = rl == null;
            boolean rightIsNull = rr == null;

            //Not a great implementation, I was playing with boolean condition and algebra simplification to keep it in one line
            return (leftIsNull && rightIsNull) ||
                    (
                            !leftIsNull &&
                                    !rightIsNull &&
                                    rl.data == rr.data &&
                                    isSymmetric(rl.left, rr.right) &&
                                    isSymmetric(rl.right, rr.left)
                    );
        }
    }
