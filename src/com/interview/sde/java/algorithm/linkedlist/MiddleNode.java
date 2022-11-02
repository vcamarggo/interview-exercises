package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast == null ? slow : slow.next;
    }
}
