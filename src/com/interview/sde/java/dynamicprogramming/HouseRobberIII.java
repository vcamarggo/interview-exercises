package com.interview.sde.java.dynamicprogramming;

import com.interview.sde.java.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber-iii
public class HouseRobberIII {
    private final Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        if (root == null)
            return 0;
        int robbing = root.val;
        if (root.left != null)
            robbing += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            robbing += rob(root.right.left) + rob(root.right.right);

        int nonRobbing = rob(root.left) + rob(root.right);

        int max = Math.max(robbing, nonRobbing);
        return memo.computeIfAbsent(root, k -> max);
    }

}
