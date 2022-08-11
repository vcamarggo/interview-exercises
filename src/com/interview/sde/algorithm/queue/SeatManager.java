package com.interview.sde.algorithm.queue;

import java.util.PriorityQueue;

//https://leetcode.com/problems/seat-reservation-manager/
public class SeatManager {

    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>(n);
        for(int i = 1 ; i<=n;i++){
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
