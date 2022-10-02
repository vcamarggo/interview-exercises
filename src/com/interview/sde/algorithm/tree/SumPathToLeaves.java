package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumPathToLeaves {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        System.out.println(sumNumbers(one));
    }

    static int sumNumbers(TreeNode root) {
        return sumNumbers(root, "");
    }

    static int sumNumbers(TreeNode root, String solution) {
        if (root == null) {
            return 0;
        }
        String newSolution = solution + root.val;
        return root.left == null && root.right == null
                ? Integer.parseInt(newSolution)
                : sumNumbers(root.left, newSolution) + sumNumbers(root.right, newSolution);
    }


}
