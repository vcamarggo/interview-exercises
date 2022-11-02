package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/merge-in-between-linked-lists/
public class MergeBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current = list1;

        //Takes the difference because after finding the insertion point,
        // the end of the merge will be the (b-a) ith node after (a) ith node
        b -= a;

        while (--a > 0) {
            current = current.next;
        }

        ListNode insertion = current;

        while (b-- >= 0) {
            current = current.next;
        }

        insertion.next = list2;

        if (current != null) {
            while (list2.next != null) {
                list2 = list2.next;
            }
            list2.next = current.next;
        }

        return list1;
    }
}
