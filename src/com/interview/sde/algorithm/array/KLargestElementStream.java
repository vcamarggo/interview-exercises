package com.interview.sde.algorithm.array;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KLargestElementStream {
    final int K;
    Queue<Integer> dataStore;

    public KLargestElementStream(int k, int[] nums) {
        this.K = k;
        dataStore = new PriorityQueue<>(k);
        for (Integer i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (dataStore.size() < K) {
            dataStore.offer(val);
        } else if (val > dataStore.peek()) {
            dataStore.poll();
            dataStore.offer(val);
        }
        return dataStore.peek();
    }

    public static void main(String[] args) {
        KLargestElementStream kles = new KLargestElementStream(1, new int[]{});
        System.out.println(kles.add(3));
        System.out.println(kles.add(5));
        System.out.println(kles.add(10));
        System.out.println(kles.add(9));
        System.out.println(kles.add(4));
    }

}
