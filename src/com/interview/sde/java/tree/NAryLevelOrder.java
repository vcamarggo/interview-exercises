package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class NAryLevelOrder {
    public List<List<Integer>> levelOrder(NAryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<NAryTreeNode> levels = new LinkedList<>();

        if (root != null) {
            levels.offer(root);
        }

        while (!levels.isEmpty()) {
            int size = levels.size();
            List<Integer> levelList = new ArrayList<>();

            while (size-- > 0) {
                NAryTreeNode node = levels.poll();
                levelList.add(node.val);

                for (NAryTreeNode child : node.children) {
                    levels.offer(child);
                }
            }
            result.add(levelList);
        }

        return result;
    }
}
