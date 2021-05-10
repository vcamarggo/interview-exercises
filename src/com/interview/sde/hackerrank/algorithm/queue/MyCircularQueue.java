package com.interview.sde.hackerrank.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MyCircularQueue {

    Deque<Integer> deck;
    int maxCapacity;


    public MyCircularQueue(int k) {
        deck = new LinkedList<>();
        this.maxCapacity = k;
    }

    public boolean enQueue(int value) {
        if(!isFull()){
            deck.offerLast(value);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()){
            deck.pollFirst();
            return true;
        }
        return false;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return deck.peekFirst();
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return deck.peekLast();
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public boolean isFull() {
        return deck.size() == maxCapacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
