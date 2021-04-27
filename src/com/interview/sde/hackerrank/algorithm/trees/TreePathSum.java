package com.interview.sde.hackerrank.algorithm.trees;

public class TreePathSum {
    public boolean hasPathSum(BSTInsertion.Node root, int targetSum) {
        if(root == null){
            return false;
        }

        int targetSumNode = targetSum - root.data;

        //isLeafNode
        if(root.left == null && root.right == null){
            return targetSumNode == 0;
        }

        return hasPathSum(root.left, targetSumNode) || hasPathSum(root.right, targetSumNode);
    }
}
