package com.interview.sde.java.queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/perfect-squares/
public class PerfectSquares {
    public static int numSquares(int n) {
        Queue<Integer> nodes = new LinkedList<>();

        nodes.add(n);
        int level = 1;
        while (!nodes.isEmpty()) {

            int toProcess = nodes.size();

            while (toProcess-- > 0) {

                Integer i = nodes.poll();

                for (int j = (int) Math.sqrt(i); j > 0; j--) {
                    int remaining = i - (j * j);
                    nodes.add(remaining);

                    if (remaining == 0) {
                        return level;
                    }
                }

            }
            level++;
        }

        return level;

    }

    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }
}
