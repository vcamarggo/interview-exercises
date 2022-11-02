package com.interview.sde.java.crackingcodeinterview;

import com.interview.sde.java.linkedlist.ListNode;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListDetectACycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
