package com.interview.sde.algorithm.datastructure;

//https://leetcode.com/problems/design-linked-list/
public class MyLinkedList {

    Node head;
    Node tail;

    public MyLinkedList() {
    }

    public int get(int index) {
        int idx = 0;
        Node temp = head;

        if (isEmptyHead()) {
            return -1;
        }

        while (idx != index && isValidNode(temp)) {
            idx++;
            temp = temp.next;
        }

        return isValidNode(temp) ? temp.val : -1;
    }

    private boolean isValidNode(Node temp) {
        return temp != null;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (isEmptyTail()) {
            tail = head;
        }
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (isEmptyHead()) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void addAtIndex(int index, int val) {
        int idx = 0;
        Node temp = head;

        if (index == 0) {
            addAtHead(val);
        }
        if (!isEmptyHead()) {
            while (idx != index - 1 && isValidNode(temp)) {
                idx++;
                temp = temp.next;
            }
            if (idx == index - 1) {
                if (temp == tail || !isValidNode(temp)) {
                    addAtTail(val);
                } else {
                    addNodeToNext(val, temp);
                }
            }
        }
    }

    private void addNodeToNext(int val, Node temp) {
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
    }

    public void deleteAtIndex(int index) {
        int idx = 0;
        Node temp = head;

        if (!isValidNode(temp) || !isValidNode(temp.next) && index == 0) {
            head = null;
            tail = null;
        } else {
            if (index == 0) {
                head = head.next;
            }

            while (idx != index - 1 && isValidNode(temp)) {
                idx++;
                temp = temp.next;
            }
            if (isValidNode(temp) && isValidNode(temp.next)) {
                if (temp.next == tail) {
                    tail = temp;
                }
                temp.next = temp.next.next;
            }

        }
    }

    private boolean isEmptyTail() {
        return !isValidNode(tail);
    }

    private boolean isEmptyHead() {
        return !isValidNode(head);
    }

    static class Node {
        final int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
