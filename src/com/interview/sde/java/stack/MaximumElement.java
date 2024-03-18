package com.interview.sde.java.stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/maximum-element/problem
public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = Integer.parseInt(scanner.nextLine());

        Stack<Integer> maxQueue = new Stack<>();

        for (int i = 0; i < queries; i++) {
            String[] query = scanner.nextLine().split(" ");
            switch (query[0]) {
                case "1" -> {
                    int numberToInsert = Integer.parseInt(query[1]);
                    maxQueue.push(maxQueue.isEmpty() ? numberToInsert : Math.max(maxQueue.peek(), numberToInsert));
                }
                case "2" -> {
                    maxQueue.pop();
                }
                case "3" -> System.out.println(maxQueue.peek());
            }
        }
    }
}
