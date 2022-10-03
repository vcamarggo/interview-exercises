package com.interview.sde.algorithm.linkedlist;


//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {


    static boolean isPalindrome(ListNode head) {
        int wholeListSize = calculateLinkedListSize(head);

        //List of size < 2 is always palindrome
        if (wholeListSize < 2) {
            return true;
        }

        int reversedListSize = wholeListSize / 2;

        ListNode previous = null;
        ListNode forwardLinkedList = head;

        for (int i = 0; i < reversedListSize; i++) {
            head = forwardLinkedList;
            forwardLinkedList = head.next;
            head.next = previous;
            previous = head;
        }

        //Make size of the lists even if it is odd
        if (wholeListSize != 2 * reversedListSize) {
            forwardLinkedList = forwardLinkedList.next;
        }

        return isPalindrome(head, forwardLinkedList);
    }

    //not making parameters final as they can be destroyed
    private static boolean isPalindrome(ListNode list1, ListNode list2) {
        while (list1 != null) {
            if (list2.val != list1.val) {
                return false;
            }
            list2 = list2.next;
            list1 = list1.next;
        }
        return true;
    }

    private static int calculateLinkedListSize(final ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode example1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode example2 = new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3))))));
        ListNode example3 = new ListNode(3);
        ListNode example4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode example5 = null;
        System.out.println(isPalindrome(example1));
    }

}
