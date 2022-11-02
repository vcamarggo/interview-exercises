package com.interview.sde.java.disjointset;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static class DisjointSet {

        final Map<Integer, Integer> parents;
        final Map<Integer, Integer> size;

        DisjointSet(int[] nums) {
            this.parents = new HashMap<>(nums.length);
            this.size = new HashMap<>(nums.length);
            for (Integer n : nums) {
                parents.put(n, n);
                size.put(n, 1);
            }
        }

        //Returns the size of the highest group or 1, meaning the "n" element itself
        int union(int a, int b) {
            if (parents.containsKey(a) && parents.containsKey(b)) {
                int parentA = findParent(a);
                int parentB = findParent(b);
                if (parentA != parentB) {
                    //union by rank
                    if (size.get(parentA) > size.get(parentB)) {
                        parents.put(parentB, parentA);
                        return size.compute(parentA, (k, v) -> v + size.get(parentB));
                    } else {
                        parents.put(parentA, parentB);
                        return size.compute(parentB, (k, v) -> v + size.get(parentA));
                    }
                }
            }
            return 1;
        }

        int findParent(int i) {
            while (i != parents.get(i)) {
                //path compression
                parents.put(i, i = parents.get(i));
            }
            return parents.get(i);
        }

    }

    public int longestConsecutive(int[] nums) {
        DisjointSet sequence = new DisjointSet(nums);

        int max = 0;
        for (Integer n : nums) {
            max = Math.max(max, Math.max(sequence.union(n, n - 1), sequence.union(n, n + 1)));
        }
        return max;
    }
}
