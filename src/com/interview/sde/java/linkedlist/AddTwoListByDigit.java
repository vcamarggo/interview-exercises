package com.interview.sde.java.linkedlist;

//https://leetcode.com/problems/add-two-numbers
public class AddTwoListByDigit {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode tmp = l1;
        int size1 = 0;
        while(tmp != null){
            size1++;
            tmp = tmp.next;
        }

        tmp = l2;
        int size2 = 0;
        while(tmp != null){
            size2++;
            tmp = tmp.next;
        }

        ListNode holder = l1;

        int maxSize = Math.max(size1, size2);

        boolean carryOver = false;
        while(maxSize > 0){
            maxSize--;

            int nodeSum = l1.val + l2.val + (carryOver ? 1 : 0);
            l1.val = nodeSum % 10;

            carryOver = nodeSum > 9;

            if(maxSize == 0){
                l1.next = carryOver ? new ListNode(1, null) : null;
            } else {
                if(l1.next == null && l2.next != null){
                    l1.next = new ListNode(0, null);
                }
                if(l2.next == null && l1.next != null){
                    l2.next = new ListNode(0, null);
                }
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        return holder;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

        return l1SizeDiff >= 0 ? l1Head : l2Head;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode h2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
//        ListNode h1 = new ListNode(9);
//        ListNode h2 = new ListNode(9);
        addTwoNumbers(h1, h2);
    }

}
