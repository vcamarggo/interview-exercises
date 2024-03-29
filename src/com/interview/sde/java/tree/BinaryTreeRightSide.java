package com.interview.sde.java.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> toProcess = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root != null) {
            toProcess.add(root);
        }

        while (!toProcess.isEmpty()) {

            result.add(toProcess.peekLast().val);
            int size = toProcess.size();
            while (size-- > 0) {
                TreeNode current = toProcess.pollFirst();
                if (current.left != null) {
                    toProcess.offerLast(current.left);
                }
                if (current.right != null) {
                    toProcess.offerLast(current.right);
                }
            }
        }

        return result;
    }

}
