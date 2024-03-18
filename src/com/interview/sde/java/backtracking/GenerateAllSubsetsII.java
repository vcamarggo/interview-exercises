package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/
public class GenerateAllSubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> solution = new ArrayList<>();
        solution.add(new ArrayList<>());

        for (int number : nums) {
            int solutionSize = solution.size();
            for (int i = 0; i < solutionSize; i++) {
                List<Integer> aggregator = new ArrayList<>(solution.get(i));
                aggregator.add(number);

                Collections.sort(aggregator);
                solution.add(aggregator);
            }
        }
        return new ArrayList<>(new HashSet<>(solution));
    }
}
