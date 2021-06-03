package com.interview.sde.algorithm.stack;

import java.util.*;

// https://www.hackerrank.com/challenges/maximum-element/problem
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());

        Stack<Integer> storageQueue = new Stack<>();
        Stack<Integer> maxQueue = new Stack<>();

        for (int i = 0; i < queries; i++) {
            String[] query = scanner.nextLine().split(" ");
            switch (query[0]) {
                case "1":
                    int numberToInsert = Integer.parseInt(query[1]);
                    storageQueue.push(numberToInsert);
                    maxQueue.push(maxQueue.isEmpty() ? numberToInsert : Math.max(maxQueue.peek(), numberToInsert));
                    continue;
                case "2":
                    storageQueue.pop();
                    maxQueue.pop();
                    continue;
                case "3":
                    System.out.println(maxQueue.peek());
            }
        }
    }
}
