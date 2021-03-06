package com.interview.sde.java.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-dequeue
public class DequeueJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> occurrencesCounter = new HashMap<>();

        int max = Integer.MIN_VALUE;

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int elem = in.nextInt();
            deque.addLast(elem);
            occurrencesCounter.put(elem, occurrencesCounter.getOrDefault(elem, 0) + 1);

            if (deque.size() == m) {
                max = Math.max(max, occurrencesCounter.keySet().size());
                int removedElement = deque.removeFirst();
                int occurrencesRemovedElement = occurrencesCounter.get(removedElement);
                if (occurrencesRemovedElement == 1) {
                    occurrencesCounter.remove(removedElement);
                } else {
                    occurrencesCounter.put(removedElement, --occurrencesRemovedElement);
                }
            }
        }
        System.out.println(max);
    }
}
