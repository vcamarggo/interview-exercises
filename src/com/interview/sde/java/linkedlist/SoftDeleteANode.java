package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class SoftDeleteANode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
