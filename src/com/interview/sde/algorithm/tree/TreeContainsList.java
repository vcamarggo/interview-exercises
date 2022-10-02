package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/linked-list-in-binary-tree/
public class TreeContainsList {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return isSubPathInternal(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSubPathInternal(ListNode current, TreeNode root) {
        if (current == null) return true;
        if (root == null) return false;
        return root.val == current.val && (isSubPathInternal(current.next, root.left) || isSubPathInternal(current.next, root.right));
    }

    public static class TreeNode {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
