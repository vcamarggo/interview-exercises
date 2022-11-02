package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
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

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 5}, {1, 2}})));
    }
}
