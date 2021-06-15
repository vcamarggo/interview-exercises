package com.interview.sde.java.datastructures;

//https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
public class InsertNodeLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode nodeTemp = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        while (nodeTemp.next != null && nodeTemp.data < data)
            nodeTemp = nodeTemp.next;

        if (nodeTemp.next == null && data > nodeTemp.data) {
            newNode.prev = nodeTemp;
            nodeTemp.next = newNode;
        } else if (nodeTemp.prev == null && data < nodeTemp.data) {
            newNode.next = nodeTemp;
            head = newNode;
        } else {
            newNode.next = nodeTemp;
            newNode.prev = nodeTemp.prev;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
        }

        return head;

    }

}
