package com.interview.sde.algorithm.trees;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
class LargestLevelBinaryTreeWidth {

    static class TreeNode {
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

    public static void main(String[] args) {
        //[1,3,2,5,3,null,2]
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(3);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(2);

        //[1,3,null,5,3]
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(3);
        tree2.left.left = new TreeNode(5);
        tree2.left.right = new TreeNode(3);

        //[1, 1,1 ,1,null, null,1,  1,null,null,1]
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(1);
        tree3.left.left = new TreeNode(1);
        tree3.left.left.left = new TreeNode(1);
        tree3.right = new TreeNode(1);
        tree3.right.right = new TreeNode(1);
        tree3.right.right.right = new TreeNode(1);

        //[1,2]
        TreeNode tree4 = new TreeNode(1);
        tree4.left = new TreeNode(1);

        //[2,1,4,3,null,5]
        //     2
        //  1     4
        //3   3     5
        TreeNode tree5 = new TreeNode(2);
        tree5.left = new TreeNode(1);
        tree5.right = new TreeNode(4);
        tree5.left.left = new TreeNode(3);
        tree5.right.left = new TreeNode(5);

        System.out.println(widthOfBinaryTree(tree));
        System.out.println(widthOfBinaryTree(tree2));
        System.out.println(widthOfBinaryTree(tree3));
        System.out.println(widthOfBinaryTree(tree4));
        System.out.println(widthOfBinaryTree(tree5));

    }

    static class PositionTreeNode {
        int position;
        TreeNode node;

        PositionTreeNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Deque<PositionTreeNode> queue = new LinkedList<>();
        queue.addFirst(new PositionTreeNode(root, 0));

        int solution = 1;

        while (!queue.isEmpty()) {

            int counter = 0;
            int nodesAtLevel = queue.size();

            int start = queue.peekFirst().position; //first at that level, leftmost
            int end = queue.peekLast().position; //last at that level, rightmost

            solution = Math.max(solution, end - start + 1);

            while (counter < nodesAtLevel) { //process all in a level
                PositionTreeNode current = queue.pollFirst();
                if (current.node.left != null) {
                    //Binary position counting, like in heap, every left child is 2 * father position
                    queue.add(new PositionTreeNode(current.node.left, 2 * current.position));
                }
                if (current.node.right != null) {
                    //Binary position counting, like in heap, every right child is 2 * father position + 1
                    queue.add(new PositionTreeNode(current.node.right, 2 * current.position + 1));
                }
                counter++;
            }
        }
        return solution;
    }


}
