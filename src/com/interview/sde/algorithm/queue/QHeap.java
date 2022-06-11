package com.interview.sde.algorithm.queue;

import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/qheap1/problem
public class QHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (int i = 0; i < queries; i++) {
            String[] query = scanner.nextLine().split(" ");
            switch (query[0]) {
                case "1":
                    minQueue.add(Integer.parseInt(query[1]));
                    continue;
                case "2":
                    minQueue.remove(Integer.parseInt(query[1]));
                    continue;
                case "3":
                    System.out.println(minQueue.peek());
            }
        }
    }
}


