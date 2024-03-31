package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class Flatten {
    private DoubleLinkedNodeChild flatten(DoubleLinkedNodeChild head) {
        DoubleLinkedNodeChild holder = head;
        while (head != null) {
            if (head.child != null) {
                flatten(head.child, head, head.next);
                head.child = null;
            }
            head = head.next;
        }
        return holder;
    }

    private void flatten(DoubleLinkedNodeChild head, DoubleLinkedNodeChild parent, DoubleLinkedNodeChild parentNext) {
        DoubleLinkedNodeChild child = head;
        DoubleLinkedNodeChild lastChildNode = null;

        child.prev = parent;
        parent.next = child;

        while (head != null) {
            if (head.child != null) {
                flatten(head.child, head, head.next);
                head.child = null;
            }
            lastChildNode = head;
            head = head.next;
        }

        if (parentNext != null) {
            lastChildNode.next = parentNext;
            parentNext.prev = lastChildNode;
        }
    }

    private static class DoubleLinkedNodeChild {
        public int val;
        public DoubleLinkedNodeChild prev;
        public DoubleLinkedNodeChild next;
        public DoubleLinkedNodeChild child;

        public DoubleLinkedNodeChild(int val) {
            this.val = val;
        }
    }
}
