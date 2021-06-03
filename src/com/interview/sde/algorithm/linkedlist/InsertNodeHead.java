package com.interview.sde.algorithm.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
public class InsertNodeHead {

        static class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;

            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }

        static class SinglyLinkedList {
            public SinglyLinkedListNode head;
            public SinglyLinkedListNode tail;

            public SinglyLinkedList() {
                this.head = null;
                this.tail = null;
            }


        }

        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
            while (node != null) {
                bufferedWriter.write(String.valueOf(node.data));

                node = node.next;

                if (node != null) {
                    bufferedWriter.write(sep);
                }
            }
        }

        // Complete the insertNodeAtHead function below.

        /*
         * For your reference:
         *
         * SinglyLinkedListNode {
         *     int data;
         *     SinglyLinkedListNode next;
         * }
         *
         */
        static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
            SinglyLinkedListNode head = new SinglyLinkedListNode(data);
            head.next= llist;
            return head;

        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);

                llist.head = llist_head;
            }



            printSinglyLinkedList(llist.head, "\n", bufferedWriter);
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        }
    }
