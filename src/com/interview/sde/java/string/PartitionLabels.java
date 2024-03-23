package com.interview.sde.java.string;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }

    List<Integer> merge(List<int[]> intervals) {
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            if (i < intervals.size() - 1 && intervals.get(i)[1] >= intervals.get(i + 1)[0]) {
                //If mergeable, merge them on the i+1 position
                intervals.set(i + 1, new int[]{intervals.get(i)[0], Math.max(intervals.get(i)[1], intervals.get(i + 1)[1])});
            } else {
                int[] interval = intervals.get(i);
                sizes.add(interval[1] - interval[0] + 1);
            }
        }

        return sizes;
    }

    public List<Integer> partitionLabels(String s) {
        List<int[]> intervals = new ArrayList<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!visited.contains(c)) {
                visited.add(c);
                int lastIndexOf = s.lastIndexOf(c);
                if (lastIndexOf == -1) {
                    intervals.add(new int[]{i, i});
                } else {
                    intervals.add(new int[]{i, lastIndexOf});
                }
            }
        }

        return merge(intervals);
    }
}
