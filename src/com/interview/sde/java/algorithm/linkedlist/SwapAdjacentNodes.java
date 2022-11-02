package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapAdjacentNodes {
    static ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode current = sentinel;
        while (current.next != null && current.next.next != null) { //If there are swappable elements
            ListNode leftSwap = current.next;

            ListNode nextLeftSwap = current.next.next.next;
            current.next = current.next.next; //rightSwap
            current.next.next = leftSwap;

            current = current.next.next;
            current.next = nextLeftSwap;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }


}
