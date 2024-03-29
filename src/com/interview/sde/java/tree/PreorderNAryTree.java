package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class PreorderNAryTree {

    public List<Integer> preorder(NAryTreeNode root) {
        List<Integer> solution = new ArrayList<>();
        preorder(root, solution);
        return solution;
    }

    public void preorder(NAryTreeNode root, List<Integer> solution) {
        if (root != null) {
            solution.add(root.val);
            for (NAryTreeNode child : root.children) {
                preorder(child, solution);
            }
        }
    }

}
