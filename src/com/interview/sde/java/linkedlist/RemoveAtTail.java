package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveAtTail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeCount = countNodes(head);

        return removeNthFromEnd(head, n, nodeCount);
    }

    public int countNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;

        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }
        return nodeCount;
    }

    public ListNode removeNthFromEnd(ListNode head, int n, int nodeCount) {
        if (nodeCount == n) {
            return head.next;
        }

        ListNode temp = head;
        while (--nodeCount - n > 0) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

}
