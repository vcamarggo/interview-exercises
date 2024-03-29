package com.interview.sde.java.tree;

//https://leetcode.com/problems/same-tree/
public class SameTree {
    boolean isSameTree(Node p, Node q) {
        return (p == null && q == null) || (p != null && q != null) && (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
