package com.interview.sde.algorithm.trees;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewcake.com/question/python/second-largest-item-in-bst
public class FindSecondBiggestTree {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static List<Integer> inOrder(BinaryTreeNode root) {
        ArrayList<Integer> orderedList = new ArrayList<>();
        if (root.left != null) {
            orderedList.addAll(inOrder(root.left));
        }
        orderedList.add(root.value);
        if (root.right != null) {
            orderedList.addAll(inOrder(root.right));
        }

        return orderedList;

    }

    public static int findSecondLargestON(BinaryTreeNode rootMode) {
        List<Integer> treeAsList = inOrder(rootMode);
        return treeAsList.get(treeAsList.size() - 2);
    }

    public static class NodeWithParent {
        final BinaryTreeNode root;
        final int parentValue;

        NodeWithParent(BinaryTreeNode root, BinaryTreeNode parent) {
            this.root = root;
            this.parentValue = parent.value;
        }

    }

    public static NodeWithParent findLargest(BinaryTreeNode root, BinaryTreeNode parent) {
        if (root.right != null) {
            return findLargest(root.right, root);
        } else {
            return new NodeWithParent(root, parent);
        }
    }

    public static int findSecondLargestLogN(BinaryTreeNode rootMode) {
        NodeWithParent largest = findLargest(rootMode, rootMode);
        if (largest.root.left != null) {
            NodeWithParent secondLargest = findLargest(largest.root.left, largest.root.left);
            return secondLargest.root.value;
        } else if (largest.parentValue != largest.root.value) {
            return largest.parentValue;
        } else {
            throw new RuntimeException("Error");
        }
    }
}
