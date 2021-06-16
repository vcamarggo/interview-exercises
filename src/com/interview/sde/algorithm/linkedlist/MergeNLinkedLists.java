package com.interview.sde.algorithm.linkedlist;

//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeNLinkedLists {

    static class ListNode {
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

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode l1 = lists[0];

        if (lists.length == 1) {
            return l1;
        }

        for (int i = 1; i < lists.length; i++) {
            l1 = mergeTwoLists(l1, lists[i]);
        }
        return l1;
    }

    static ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode headNodeToReturn = (head1.val > head2.val) ? head2 : head1;

        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                head2 = walkOnList(head1, head2);

            } else {
                head1 = walkOnList(head2, head1);
            }
        }
        return headNodeToReturn;
    }

    private static ListNode walkOnList(ListNode biggerNumberListHead, ListNode smallerNumberListHead) {
        ListNode holderHead;

        while (smallerNumberListHead.next != null && smallerNumberListHead.next.val <= biggerNumberListHead.val) {
            smallerNumberListHead = smallerNumberListHead.next;
        }

        holderHead = smallerNumberListHead.next;
        smallerNumberListHead.next = biggerNumberListHead;
        smallerNumberListHead = holderHead;
        return smallerNumberListHead;
    }

    //Implemented with mentee
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode currentNode = null;
        ListNode head = null;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 != null && l2.val < l1.val) {
                if (head == null) { //test if solution is empty
                    head = new ListNode(l2.val);
                    currentNode = head;
                } else { // if it's not, create a new node, set the currentNode, walk the currentNode
                    currentNode.next = new ListNode(l2.val);
                    currentNode = currentNode.next;
                }
                l2 = l2.next;
            } else {
                if (head == null) {
                    head = new ListNode(l1.val);
                    currentNode = head;
                } else {
                    currentNode.next = new ListNode(l1.val);
                    currentNode = currentNode.next;
                }
                l1 = l1.next;
            }
        }
        return head;
    }

}
