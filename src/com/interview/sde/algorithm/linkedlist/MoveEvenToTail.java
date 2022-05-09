package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/odd-even-linked-list
public class MoveEvenToTail {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = head;
        int count = 1;

        while (tail.next != null) {
            count++;
            tail = tail.next;
        }

        ListNode aux = head;

        if (count > 2) {
            count /= 2;

            while (count-- > 0) {
                ListNode moveToTail = aux.next;
                aux.next = aux.next.next;
                aux = aux.next;

                moveToTail.next = null;
                tail.next = moveToTail;
                tail = tail.next;
            }
        }

        return head;

    }

    public class ListNode {
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
