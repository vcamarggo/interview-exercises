package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupByGroupSize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int key = groupSizes[i];
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
            List<Integer> groupElements = groups.get(key);
            if (groupElements.size() == key) {
                result.add(new ArrayList<>(groupElements));
                groupElements.clear();
            }
        }

        return result;
    }
}
