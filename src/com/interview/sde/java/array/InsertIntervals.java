package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/insert-interval/
public class InsertIntervals {
    static int[][] merge(int[][] intervals) {
        ArrayList<int[]> mergedIntervals = new ArrayList<>(intervals.length);

        //Sort to avoid comparing all n**2 comparisons
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (i < intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                //If mergeable, merge them on the i+1 position
                intervals[i + 1] = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])};
            } else {
                //When not mergeable, mark the index for posterior collection
                mergedIntervals.add(intervals[i]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] unmergedIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        unmergedIntervals[intervals.length] = newInterval;
        return merge(unmergedIntervals);
    }
}
