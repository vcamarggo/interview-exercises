package com.interview.sde.java.datastructures;

//https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
public class InsertNodePositionLinkedList {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode nodeTemp = head.next;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        for (int index = 0; index < position - 2; index++)
            nodeTemp = nodeTemp.next;

        newNode.next = nodeTemp.next;
        nodeTemp.next = newNode;
        return head;

    }


}
