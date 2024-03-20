package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/add-two-numbers-ii/
public class AddTwoListByDigits2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);

        l2 = reverse(l2);

        ListNode l1Head = l1;
        ListNode l2Head = l2;

        ListNode lastUsedNode = null;

        boolean carryOver = false;
        int l1SizeDiff = 0;

        while (l1 != null || l2 != null) {
            int newVal = carryOver ? 1 : 0;

            if (l1 != null && l2 != null) {
                newVal += (l1.val + l2.val);
                l1.val = newVal % 10;
                l2.val = newVal % 10;
                lastUsedNode = l1;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                newVal += l2.val;
                l2.val = newVal % 10;
                lastUsedNode = l2;
                l2 = l2.next;
                l1SizeDiff--;
            } else {
                //l1 is not null
                newVal += l1.val;
                l1.val = newVal % 10;
                lastUsedNode = l1;
                l1 = l1.next;
                l1SizeDiff++;
            }

            //mod 10 had overflow
            carryOver = newVal >= 10;

        }

        if (carryOver) {
            lastUsedNode.next = new ListNode(1);
        }

        return l1SizeDiff >= 0 ? reverse(l1Head) : reverse(l2Head);

    }

    static ListNode reverse(ListNode head) {
        ListNode previousNode = null;
        while (head != null) {
            ListNode nextNode = head.next;

            head.next = previousNode;

            previousNode = head;

            head = nextNode;

        }
        return previousNode;
    }
}
