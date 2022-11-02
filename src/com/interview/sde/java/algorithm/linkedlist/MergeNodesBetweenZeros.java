package com.interview.sde.algorithm.linkedlist;
//https://leetcode.com/problems/merge-nodes-in-between-zeros/
public class MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.next.val != 0) {
                //general case of accumulating nodes between zero
                current.val += current.next.val;
                current.next = current.next.next;
            } else if (current.next != null && current.next.next == null) {
                //end node is zero and it is removed
                current.next = null;
            } else {
                //other zero nodes being moved forward to start accumulating
                current = current.next;
            }
        }

        return head;
    }
}
