package com.interview.sde.java.crackingcodeinterview;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
public class QueuesATaleofTwoStacks {
    public static class MyQueue<T> {
        Stack<T> s1 = new Stack<>();
        Stack<T> s2 = new Stack<>();

        public void enqueue(T value) { // Push onto the newest stack
            s1.push(value);
        }

        public T peek() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public T dequeue() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

