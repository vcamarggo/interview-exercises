package com.interview.sde.hackerrank.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues
public class StackTwoQueue {
    static class MyStack {

        Queue<Integer> temp;
        Queue<Integer> data;
        int topValue;

        public MyStack() {
            temp = new LinkedList<>();
            data = new LinkedList<>();
        }

        public void push(int value) {
            topValue = value;
            data.offer(value);
        }

        public int pop() {
            while (data.size() > 1) {
                int removed = data.poll();
                temp.offer(removed);
                topValue = removed;
            }
            int result = data.poll();
            rewindQueues();
            return result;
        }

        public int top() {
            return topValue;
        }

        private void rewindQueues() {
            data = temp;
            temp = new LinkedList<>();
        }

        public boolean empty() {
            return data.isEmpty() && temp.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
