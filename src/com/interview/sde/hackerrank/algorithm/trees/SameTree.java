package com.interview.sde.hackerrank.algorithm.trees;

//https://leetcode.com/problems/same-tree/
public class SameTree {
    boolean isSameTree(InsertBST.Node p, InsertBST.Node q) {
        return (p == null && q == null) || (p != null && q != null) && (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
