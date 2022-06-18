package com.interview.sde.algorithm.queue;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements
public class TopKFrequent {
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberCounter = new HashMap<>();
        for (int num : nums) {
            numberCounter.put(num, numberCounter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> kFrequent = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : numberCounter.entrySet()) {
            if (kFrequent.size() < k) {
                kFrequent.add(entry);
            } else if (kFrequent.peek().getValue() < entry.getValue()) {
                kFrequent.poll();
                kFrequent.add(entry);
            }
        }

        return kFrequent.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }
}
