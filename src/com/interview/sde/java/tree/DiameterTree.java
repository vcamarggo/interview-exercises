package com.interview.sde.java.tree;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterTree {


    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3))));
    }

    static int height(TreeNode root) {
        return root == null
                ? 0
                : Math.max(height(root.left) + 1, height(root.right) + 1);
    }

    static int diameterOfBinaryTree(TreeNode root) {
        return root == null
                ? 0
                : Math.max(height(root.left) + height(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

}
