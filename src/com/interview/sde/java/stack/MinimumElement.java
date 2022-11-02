package com.interview.sde.java.stack;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinimumElement {

    Stack<Integer> storageQueue;
    Stack<Integer> minQueue;

    /**
     * initialize your data structure here.
     */
    public MinimumElement() {
        storageQueue = new Stack<>();
        minQueue = new Stack<>();
    }

    public void push(int numberToInsert) {
        storageQueue.push(numberToInsert);
        minQueue.push(minQueue.isEmpty() ? numberToInsert : Math.min(minQueue.peek(), numberToInsert));
    }

    public void pop() {
        storageQueue.pop();
        minQueue.pop();
    }

    public int top() {
        return storageQueue.peek();
    }

    public int getMin() {
        return minQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
