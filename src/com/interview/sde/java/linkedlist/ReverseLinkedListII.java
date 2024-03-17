package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListII {
    public static void main(String[] args) {
        new ReverseLinkedListII().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        new ReverseLinkedListII().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 5);
        new ReverseLinkedListII().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 1, 4);
        new ReverseLinkedListII().reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Create a sentinel to remove edge case
        ListNode sentinelHead = new ListNode(-1, head);
        head = sentinelHead;
        int position = 0;

        //Find the start reverse position (one position before the left)
        while (head != null && position < left - 1) {
            head = head.next;
            position++;
        }


        //Save the pre-reverse position
        //This is necessary to fix the tail after reversing
        ListNode sentinelReverse = head;
        ListNode firstReversed = head.next;

        //Advance the pointer to the start of the list to be reversed
        ListNode prev = null;
        head = head.next;

        //Reverse until find end reverse position
        while (head != null && position < right) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            position++;
        }

        //Make the position before the start reverse point to the last reversed node
        sentinelReverse.next = prev;
        //Make the last reversed node point to the next not-reversed node
        firstReversed.next = head;

        return sentinelHead.next;
    }
}
