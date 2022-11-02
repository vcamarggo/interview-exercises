package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class GenerateAllSubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> solution = new ArrayList<>();

        for (int number : nums) {
            if (!solution.isEmpty()) {
                int solutionSize = solution.size();
                for (int i = 0; i < solutionSize; i++) {
                    List<Integer> aggregator = new ArrayList<>(solution.get(i));
                    aggregator.add(number);

                    Collections.sort(aggregator);
                    solution.add(aggregator);
                }
            }
            solution.add(new ArrayList<>(Collections.singletonList(number)));
        }
        solution.add(new ArrayList<>());
        return new ArrayList<>(new HashSet<>(solution));
    }
}
