package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst
public class KthSmallestTree {


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
