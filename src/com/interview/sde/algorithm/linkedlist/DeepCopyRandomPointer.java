package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class DeepCopyRandomPointer {
    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node ten = new Node(10);
        Node one = new Node(1);

        seven.next = thirteen;
        seven.random = null;

        thirteen.next = eleven;
        thirteen.random = seven;

        eleven.next = ten;
        eleven.random = one;

        ten.next = one;
        ten.random = eleven;

        one.next = null;
        one.random = seven;

        Node n = new DeepCopyRandomPointer().copyRandomList(seven);
        System.out.println(n);
    }

    public Node copyRandomList(Node head) {
        Node current = head;
        //Copy the nodes
        while (current != null) {
            Node copiedNode = new Node(current.val);
            copiedNode.next = current.next;
            current.next = copiedNode;
            current = current.next.next;
        }

        current = head;
        //Copy the random pointers
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        Node copiedListHead = null;
        Node copiedListCurrent = null;
        current = head;
        //Extract the new copied list and restore the original
        while (current != null) {
            if (copiedListHead == null) {
                copiedListHead = current.next;
                copiedListCurrent = copiedListHead;
            } else {
                copiedListCurrent.next = current.next;
                copiedListCurrent = copiedListCurrent.next;
            }
            current.next = current.next.next;
            current = current.next;
        }


        return copiedListHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
