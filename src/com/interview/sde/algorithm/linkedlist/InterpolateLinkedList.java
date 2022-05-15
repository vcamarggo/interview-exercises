package com.interview.sde.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/reorder-list/
public class InterpolateLinkedList {
    private static int countNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;

        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }

        return nodeCount;
    }

    static void reorderList(ListNode head) {
        Stack<ListNode> even = new Stack<>();
        Queue<ListNode> odd = new LinkedList<>();

        double halfNodeCount = Math.ceil(countNodes(head) / 2.0);

        int i = 1;
        while (head != null) {
            if (i <= halfNodeCount) {
                odd.offer(head);
            } else {
                even.push(head);
            }
            i++;
            head = head.next;
        }

        head = odd.poll();
        ListNode temp = head;

        i = 0;
        while (!even.isEmpty() || !odd.isEmpty()) {
            if (i % 2 == 1) {
                temp.next = odd.poll();
            } else {
                temp.next = even.pop();
            }
            i++;
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }

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
}
