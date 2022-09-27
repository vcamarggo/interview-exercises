package com.interview.sde.algorithm.sorting;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return IntStream
                .of(arr)
                .boxed()
                .sorted((a, b) -> {
                    int absAX = Math.abs(a - x);
                    int absBX = Math.abs(b - x);
                    if (absAX == absBX) {
                        return Integer.compare(a, b);
                    }
                    return Integer.compare(absAX, absBX);
                })
                .limit(k)
                .sorted()
                .collect(Collectors.toList());
    }
}
