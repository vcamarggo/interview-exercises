package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//https://leetcode.com/problems/data-stream-as-disjoint-intervals
public class SummaryRanges {
    TreeSet<Integer> nums;

    public SummaryRanges() {
        nums = new TreeSet<>();
    }

    public void addNum(int value) {
        nums.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        if (!nums.isEmpty()) {
            int start = nums.first();
            int prev = nums.first();
            for (Integer n : nums) {
                if (n != start) {
                    if (n != prev + 1) {
                        intervals.add(new int[]{start, prev});
                        start = n;
                    }
                    prev = n;
                }
            }
            intervals.add(new int[]{start, prev});
        }
        return intervals.toArray(new int[0][2]);
    }
}
