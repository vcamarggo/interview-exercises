package com.interview.sde.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
public class NAryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> levels = new LinkedList<>();

        if (root != null) {
            levels.offer(root);
        }

        while (!levels.isEmpty()) {
            int size = levels.size();
            List<Integer> levelList = new ArrayList<>();

            while (size-- > 0) {
                Node node = levels.poll();
                levelList.add(node.val);

                for (Node child : node.children) {
                    levels.offer(child);
                }
            }
            result.add(levelList);
        }

        return result;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
