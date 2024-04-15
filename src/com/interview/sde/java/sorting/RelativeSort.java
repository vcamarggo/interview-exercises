package com.interview.sde.java.sorting;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//https://leetcode.com/problems/relative-sort-array/
public class RelativeSort {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> order = new LinkedHashSet<>();
        for (int n : arr2) {
            order.add(n);
        }

        Map<Integer, Integer> numberCounter = new TreeMap<>();
        for (int n : arr1) {
            numberCounter.compute(n, (key, v) -> v == null ? 1 : v + 1);
        }

        int i = 0;
        for (int n : order) {
            while (numberCounter.getOrDefault(n, 0) > 0) {
                arr1[i] = n;
                numberCounter.compute(n, (key, v) -> v == 1 ? null : v - 1);
                i++;
            }
        }

        for (Map.Entry<Integer, Integer> entry : numberCounter.entrySet()) {
            int n = entry.getKey();
            int itr = entry.getValue();
            while (itr-- > 0) {
                arr1[i] = n;
                i++;
            }
        }
        return arr1;
    }
    
}
