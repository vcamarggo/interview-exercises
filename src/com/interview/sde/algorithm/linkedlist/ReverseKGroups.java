package com.interview.sde.algorithm.linkedlist;

import java.util.Stack;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseKGroups {
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

    public ListNode reverseKGroup(ListNode current, int k) {
        Stack<ListNode> reversed = new Stack<>();
        ListNode result = null;
        ListNode newCurrent = null;

        int executions = calculateListSize(current) / k;

        while (executions-- > 0) {
            int tempK = k;

            while (tempK-- > 0) {
                reversed.push(current);
                current = current.next;
            }

            while (!reversed.isEmpty()) {
                if (result == null) {
                    result = reversed.pop();
                    newCurrent = result;
                } else {
                    newCurrent.next = reversed.pop();
                    newCurrent = newCurrent.next;
                }
            }
        }
        newCurrent.next = current;

        return result;
    }

    private int calculateListSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        new ReverseKGroups().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
    }
}
