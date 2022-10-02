package com.interview.sde.algorithm.tree;

public class NodesEqualsAverageSubtree {
    //SUM and COUNT are required for average
    final int SUM = 0;
    final int COUNT = 1;
    //RESULT is the count of nodes equals their subtree average up to that node,
    //each subtree knows itself, the root knows all
    final int RESULT = 2;

    public int averageOfSubtree(TreeNode root) {
        return countNodeEqualsSubtreeAverage(root)[RESULT];
    }

    int[] countNodeEqualsSubtreeAverage(TreeNode root) {
        int[] subtreeData = new int[3];
        subtreeData[SUM] = root.val;
        subtreeData[COUNT] = 1;

        if (root.left != null) {
            int[] subtreeDataLeft = countNodeEqualsSubtreeAverage(root.left);
            subtreeData[SUM] += subtreeDataLeft[SUM];
            subtreeData[COUNT] += subtreeDataLeft[COUNT];
            subtreeData[RESULT] += subtreeDataLeft[RESULT];
        }

        if (root.right != null) {
            int[] subtreeDataRight = countNodeEqualsSubtreeAverage(root.right);
            subtreeData[SUM] += subtreeDataRight[SUM];
            subtreeData[COUNT] += subtreeDataRight[COUNT];
            subtreeData[RESULT] += subtreeDataRight[RESULT];
        }

        if (root.left == null && root.right == null || subtreeData[SUM] / subtreeData[COUNT] == root.val) {
            subtreeData[RESULT]++;
        }

        return subtreeData;
    }


}
