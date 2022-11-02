package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class BinaryTreeLowestCommonAncestor {
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = findPath(root, p);
        List<TreeNode> pathToQ = findPath(root, q);
        int minSizePath = Math.min(pathToP.size(), pathToQ.size());
        for (int i = 0; i < minSizePath; i++) {
            if (pathToP.get(i) != pathToQ.get(i)) {
                return pathToP.get(i - 1);
            }
        }
        return pathToP.get(minSizePath - 1);
    }

    static List<TreeNode> findPath(TreeNode root, TreeNode toFind) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root == toFind) {
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        List<TreeNode> solutionLeft = findPath(root.left, toFind);
        if (!solutionLeft.isEmpty()) {
            solutionLeft.add(0, root);
            return solutionLeft;
        }
        List<TreeNode> solutionRight = findPath(root.right, toFind);
        if (!solutionRight.isEmpty()) {
            solutionRight.add(0, root);
            return solutionRight;
        }
        return Collections.emptyList();
    }

}
