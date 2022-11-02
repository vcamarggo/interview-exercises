package com.interview.sde.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class TreePathSumII {

    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    static List<List<Integer>> pathSum(TreeNode root, int targetSum, int currentSum) {
        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }

        currentSum += root.val;

        if (root.left == null && root.right == null && targetSum == currentSum) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            solution.add(path);
            return solution;
        }

        if (root.left != null) {
            List<List<Integer>> solutionLeft = pathSum(root.left, targetSum, currentSum);
            if (!solutionLeft.isEmpty()) {
                for (List<Integer> path : solutionLeft) {
                    path.add(0, root.val);
                }
            }
            solution.addAll(solutionLeft);
        }

        if (root.right != null) {
            List<List<Integer>> solutionRight = pathSum(root.right, targetSum, currentSum);
            if (!solutionRight.isEmpty()) {
                for (List<Integer> path : solutionRight) {
                    path.add(0, root.val);
                }
            }
            solution.addAll(solutionRight);
        }

        return solution;
    }


}
