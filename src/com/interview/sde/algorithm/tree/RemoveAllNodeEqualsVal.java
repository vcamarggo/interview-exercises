package com.interview.sde.algorithm.tree;

import com.interview.sde.algorithm.linkedlist.ListNode;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveAllNodeEqualsVal {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = head;

        if (head == null)
            return null;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        if (sentinel.val == val) {
            return sentinel.next;
        }
        return sentinel;
    }


}
