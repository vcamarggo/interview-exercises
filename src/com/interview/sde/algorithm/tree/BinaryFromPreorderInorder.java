package com.interview.sde.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BinaryFromPreorderInorder {
    private final Map<Integer, Integer> inorderPosition = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderPosition.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int start, int end) {
        if (start <= end) {

            TreeNode root = new TreeNode(preorder[preorderIndex++]);

            root.left = buildTree(preorder, start, inorderPosition.get(root.val) - 1);
            root.right = buildTree(preorder, inorderPosition.get(root.val) + 1, end);

            return root;
        }
        return null;

    }

}
