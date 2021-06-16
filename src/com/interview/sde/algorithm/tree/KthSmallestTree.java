package com.interview.sde.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst
public class KthSmallestTree {


    public class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> treeAsList = inOrder(root);
        return treeAsList.get(k - 1);

    }

    List<Integer> inOrder(TreeNode root) {
        List<Integer> orderedList = new ArrayList<>();
        if (root.left != null) {
            orderedList.addAll(inOrder(root.left));
        }
        orderedList.add(root.val);
        if (root.right != null) {
            orderedList.addAll(inOrder(root.right));
        }
        return orderedList;
    }
}
