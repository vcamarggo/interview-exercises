package com.interview.sde.java.tree;

import com.interview.sde.java.linkedlist.ListNode;

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



}
