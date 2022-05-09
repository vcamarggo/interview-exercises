package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
public class SwapNodesLinkedList {
    static ListNode swapNodes(ListNode head, int k) {
        final int nodeCount = countNodes(head);
        final ListNode startNode = removeNthFromEnd(head, 1, k);
        final ListNode endNode = removeNthFromEnd(head, k, nodeCount);

        final int temp = startNode.val;
        startNode.val = endNode.val;
        endNode.val = temp;

        return head;
    }

    static int countNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;

        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }
        return nodeCount;
    }

    static ListNode removeNthFromEnd(ListNode head, int n, int nodeCount) {
        if (nodeCount == n) {
            return head;
        }

        ListNode temp = head;
        while (--nodeCount - n > 0) {
            temp = temp.next;
        }

        return temp.next;
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
