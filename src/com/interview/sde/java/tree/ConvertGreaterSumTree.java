package com.interview.sde.java.tree;

//https://leetcode.com/problems/convert-bst-to-greater-tree/
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class ConvertGreaterSumTree {
    int acc = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        if(root.right != null){
            root.right = convertBST(root.right);
        }

        root.val += acc;
        acc = root.val;

        if(root.left != null){
            root.left =  convertBST(root.left);
        }

        return root;
    }
}
