package com.interview.sde.java.tree;

import java.util.List;

public class NAryTreeNode {

    public int val;
    public List<NAryTreeNode> children;

    public NAryTreeNode() {
    }

    public NAryTreeNode(int _val) {
        val = _val;
    }

    public NAryTreeNode(int _val, List<NAryTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
