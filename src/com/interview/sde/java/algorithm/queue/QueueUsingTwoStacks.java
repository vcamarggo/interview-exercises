package com.interview.sde.algorithm.queue;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
public class QueueUsingTwoStacks {

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

    public static class MyQueue<T> {
        Stack<T> s1 = new Stack<>();
        Stack<T> s2 = new Stack<>();

        public void enqueue(T value) { // Push onto newest stack
            s1.push(value);
        }

        public T peek() {
            copyS1ToS2();
            return s2.peek();
        }

        public T dequeue() {
            copyS1ToS2();
            return s2.pop();
        }

        private void copyS1ToS2() {
            if (s2.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }
        }
    }
}


