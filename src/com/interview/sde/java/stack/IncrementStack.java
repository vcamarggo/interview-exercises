package com.interview.sde.java.stack;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class IncrementStack {
    int[] stack;
    int topIndex = -1;

    public IncrementStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (topIndex < stack.length - 1) {
            stack[++topIndex] = x;
        }
    }

    public int pop() {
        if (topIndex == -1) {
            return topIndex;
        }
        return stack[topIndex--];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= topIndex; i++) {
            stack[i] += val;
        }
    }
}
