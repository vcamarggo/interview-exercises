package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/rotate-list/
public class RotateLinkedList {
    static int countNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;

        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }

        return nodeCount;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int nodeCount = countNodes(head);

        int rotation = k % nodeCount;

        if (rotation == 0) {
            return head; //No rotation
        }

        ListNode temp = findPreviousOfNewHead(head, nodeCount, rotation);

        ListNode originalHead = head; //Save the previous head
        head = temp.next; //Assign the new head
        temp.next = null; //Assign the end of the list

        temp = findLastElement(head);

        temp.next = originalHead; //Assign the next of the last element to the originalHead

        return head;
    }

    private ListNode findLastElement(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    private ListNode findPreviousOfNewHead(ListNode head, int nodeCount, int rotation) {
        ListNode temp = head;
        while (--nodeCount - rotation > 0) {
            temp = temp.next;
        }
        return temp;
    }


}
