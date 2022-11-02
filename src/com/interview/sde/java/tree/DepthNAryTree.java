package com.interview.sde.java.tree;

import java.util.List;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class DepthNAryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child) + 1);
        }
        return max;
    }

    static class Node {
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
