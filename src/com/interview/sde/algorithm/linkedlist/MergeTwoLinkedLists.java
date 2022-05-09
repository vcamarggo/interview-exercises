package com.interview.sde.algorithm.linkedlist;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeTwoLinkedLists {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        SinglyLinkedListNode headNodeToReturn = (head1.data > head2.data) ? head2 : head1;

        while (head1 != null && head2 != null) {
            if (head1.data > head2.data) {
                head2 = walkOnList(head1, head2);

            } else {
                head1 = walkOnList(head2, head1);
            }
        }
        return headNodeToReturn;
    }

    // Complete the mergeLists function below.

    private static SinglyLinkedListNode walkOnList(SinglyLinkedListNode biggerNumberListHead, SinglyLinkedListNode smallerNumberListHead) {
        SinglyLinkedListNode holderHead;

        while (smallerNumberListHead.next != null && smallerNumberListHead.next.data <= biggerNumberListHead.data) {
            smallerNumberListHead = smallerNumberListHead.next;
        }

        holderHead = smallerNumberListHead.next;
        smallerNumberListHead.next = biggerNumberListHead;
        smallerNumberListHead = holderHead;
        return smallerNumberListHead;
    }

    //Implemented with mentee
    public static SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {

        SinglyLinkedListNode currentNode = null;
        SinglyLinkedListNode head = null;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 != null && l2.data < l1.data) {
                if (head == null) { //test if solution is empty
                    head = new SinglyLinkedListNode(l2.data);
                    currentNode = head;
                } else { // if it's not, create a new node, set the currentNode, walk the currentNode
                    currentNode.next = new SinglyLinkedListNode(l2.data);
                    currentNode = currentNode.next;
                }
                l2 = l2.next;
            } else {
                if (head == null) {
                    head = new SinglyLinkedListNode(l1.data);
                    currentNode = head;
                } else {
                    currentNode.next = new SinglyLinkedListNode(l1.data);
                    currentNode = currentNode.next;
                }
                l1 = l1.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            SinglyLinkedListNode llist3 = mergeTwoLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ");
            System.out.println();
        }


        scanner.close();
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
}
