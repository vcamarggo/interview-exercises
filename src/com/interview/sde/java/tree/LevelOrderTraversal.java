package com.interview.sde.java.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
public class LevelOrderTraversal {
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> treeLevelQueue = new LinkedList<>();
        treeLevelQueue.add(root);
        while (!treeLevelQueue.isEmpty()) {
            TreeNode node = treeLevelQueue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                treeLevelQueue.add(node.left);
            }
            if (node.right != null) {
                treeLevelQueue.add(node.right);
            }
        }
    }

}
