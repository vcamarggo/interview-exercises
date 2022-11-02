package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class PreorderNAryTree {

    public List<Integer> preorder(Node root) {
        List<Integer> solution = new ArrayList<>();
        preorder(root, solution);
        return solution;
    }

    public void preorder(Node root, List<Integer> solution) {
        if (root != null) {
            solution.add(root.val);
            for (Node child : root.children) {
                preorder(child, solution);
            }
        }
    }

    // Definition for a Node.
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
