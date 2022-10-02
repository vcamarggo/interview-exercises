package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class EvenGrandparentSum {
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, false, false);
    }

    public int sumEvenGrandparent(TreeNode root, boolean evenGrandparent, boolean evenParent) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        boolean isEven = root.val % 2 == 0;
        if (evenGrandparent) {
            sum += root.val;
        }
        return sum + sumEvenGrandparent(root.left, evenParent, isEven) + sumEvenGrandparent(root.right, evenParent, isEven);
    }

}
