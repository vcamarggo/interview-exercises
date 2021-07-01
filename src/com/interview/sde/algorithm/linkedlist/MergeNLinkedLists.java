package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeNLinkedLists {

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

    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode l1 = lists[0];

        if (lists.length == 1) {
            return l1;
        }

        for (int i = 1; i < lists.length; i++) {
            l1 = mergeLists(l1, lists[i]);
        }
        return l1;
    }

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

}
