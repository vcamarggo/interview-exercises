package com.interview.sde.hackerrank.algorithm.trees;

import java.util.*;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst
public class SumOnBST {

    // Final form O(N) + space(N)
    public boolean inOrder(Set<Integer> solution, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (solution.contains(k - root.val))
            return true;
        solution.add(root.val);
        return inOrder(solution, root.left, k) || inOrder(solution, root.right, k);
    }

    boolean findTarget(TreeNode root, int k) {
        return inOrder(new HashSet<>(), root, k);
    }

    //First implementation O(2N + N log N) + space (2N)
    /*boolean findTargetFirstImplementation(TreeNode root, int k) {
        List<Integer> orderedTree = inOrder(root);
        int[] treeForBinarySearch = orderedTree.stream().mapToInt(i -> i).toArray();
        if (orderedTree.size() <= 1) {
            return false;
        }
        for (int i = 0; i < orderedTree.size(); i++) {
            int elementAtI = treeForBinarySearch[i];
            int binarySearchAt = Arrays.binarySearch(treeForBinarySearch, k - elementAtI);
            if (binarySearchAt < orderedTree.size() && binarySearchAt >= 0 && treeForBinarySearch[binarySearchAt] != elementAtI) {
                return true;
            }
        }
        return false;
    }

    List<Integer> inOrder(TreeNode root) {
        List<Integer> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }
        if (root.left != null) {
            solution.addAll(inOrder(root.left));
        }
        solution.add(root.val);
        if (root.right != null) {
            solution.addAll(inOrder(root.right));
        }
        return solution;
    }*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
