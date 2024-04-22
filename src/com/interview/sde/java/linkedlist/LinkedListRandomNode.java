package com.interview.sde.java.linkedlist;

import java.util.Random;

//https://leetcode.com/problems/linked-list-random-node
public class LinkedListRandomNode {
    final int n;
    final ListNode head;
    final Random generator = new Random();

    public LinkedListRandomNode(ListNode head) {
        this.n = countNodes(head);
        this.head = head;
    }

    public int getRandom() {
        int count = generator.nextInt(n);
        ListNode temp = head;

        while (count-- > 0) {
            temp = temp.next;
        }

        return temp.val;
    }

    private int countNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;

        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }

        return nodeCount;
    }

}
