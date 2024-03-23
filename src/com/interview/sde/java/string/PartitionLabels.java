package com.interview.sde.java.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.printf(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij").toString());
    }

    public List<Integer> partitionLabels(String s) {
        List<int[]> intervals = new ArrayList<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!visited.contains(c)) {
                visited.add(c);
                int lastIndexOf = s.lastIndexOf(c);
                if (!intervals.isEmpty() && intervals.getLast()[0] < i && intervals.getLast()[1] > i) {
                    intervals.getLast()[1] = Math.max(intervals.getLast()[1], lastIndexOf);
                } else if (lastIndexOf == -1) {
                    intervals.add(new int[]{i, i});
                } else {
                    intervals.add(new int[]{i, lastIndexOf});
                }
            }
        }

        // Faster but less idiomatic
        //List<Integer> sizes = new ArrayList<>();
        //for (int[] interval : intervals) {
        //    sizes.add(interval[1] - interval[0] + 1);
        //}
        //return sizes;

        return intervals.stream().map(interval -> interval[1] - interval[0] + 1).collect(Collectors.toList());
    }
}
