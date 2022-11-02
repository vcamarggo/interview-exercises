package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatedNodesSortedI {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headHolder = new ListNode(0, head);
        ListNode previous = headHolder;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                previous.next = head.next;
            } else {
                previous = head;
            }
            head = head.next;
        }

        return headHolder.next;
    }


}

