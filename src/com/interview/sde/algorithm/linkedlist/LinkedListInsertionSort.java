package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/insertion-sort-list/
//https://leetcode.com/problems/sort-list/
public class LinkedListInsertionSort {
    ListNode insertionSortList(ListNode current) {
        if (current == null) {
            return null;
        }

        final ListNode sentinel = new ListNode(Integer.MIN_VALUE, current);

        while (current.next != null) {
            if (current.next.val < current.val) {
                final ListNode smallerNode = current.next; // save which node we plan to insert earlier in the list
                final ListNode nodeBeforeRightPosition = findNodeBeforeRightPosition(current, sentinel);
                current.next = current.next.next; //skip smaller node as it will be inserted before in the list
                smallerNode.next = nodeBeforeRightPosition.next; //points the small node to the first node bigger than it
                nodeBeforeRightPosition.next = smallerNode; //put the smaller node in the right position
            } else {
                current = current.next;
            }
        }

        return sentinel.next;
    }

    private ListNode findNodeBeforeRightPosition(ListNode current, ListNode smallestNode) {
        while (smallestNode.next != null && smallestNode.next.val < current.next.val) {
            smallestNode = smallestNode.next;
        }
        return smallestNode;
    }

}
