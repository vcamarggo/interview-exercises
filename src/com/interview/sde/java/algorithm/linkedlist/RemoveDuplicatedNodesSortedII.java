package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatedNodesSortedII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headHolder = new ListNode(Integer.MIN_VALUE, head);
        ListNode previous = headHolder;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                previous.next = head.next;
            } else {
                previous = head;
            }
            head = head.next;
        }
        return headHolder.next;
    }


}

