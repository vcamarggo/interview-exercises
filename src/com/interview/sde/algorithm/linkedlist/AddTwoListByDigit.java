package com.interview.sde.algorithm.linkedlist;

//https://leetcode.com/problems/add-two-numbers
public class AddTwoListByDigit {
    public static class ListNode {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        boolean carryOver = false;
        int l1Size = 0;
        int l2Size = 0;
        while (l1 != null || l2 != null) {
            int newVal = carryOver ? 1 : 0;

            if (l1 != null && l2 != null) {
                newVal += (l1.val + l2.val);
                l1.val = newVal % 10;
                l2.val = newVal % 10;
                l1 = l1.next;
                l2 = l2.next;
                l1Size++;
                l2Size++;
            } else if (l2 != null) {
                newVal += l2.val;
                l2.val = newVal % 10;
                l2 = l2.next;
                l2Size++;
            } else {
                //l1 is not null
                newVal += l1.val;
                l1.val = newVal % 10;
                l1 = l1.next;
                l1Size++;
            }

            //mod 10 had overflow
            carryOver = newVal >= 10;
        }

        if (carryOver) {
            ListNode head = l1Size > l2Size ? l1Head : l2Head;
            int nodesToProcess = Math.max(l1Size, l2Size);
            while (--nodesToProcess > 0) {
                head = head.next;
            }
            head.next = new ListNode(1);
        }

        return l1Size > l2Size ? l1Head : l2Head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode h2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode h1 = new ListNode(9);
//        ListNode h2 = new ListNode(9);
        addTwoNumbers(h1, h2);
    }
}
