package com.interview.sde.hackerrank.crackingcodeinterview;

import java.util.HashSet;
import java.util.Set;

//https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
public class LinkedListDetectACycle {
    /*
    Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
    */
    class Node {
        int data;
        Node next;
    }


    boolean hasCycle(Node head) {
        Set<Node> uniqueNodes = new HashSet<>();
        while (head != null) {
            uniqueNodes.add(head);

            if (uniqueNodes.contains(head.next)) {
                return true;
            }

            head = head.next;
        }
        return false;
    }
}
