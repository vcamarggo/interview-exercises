package com.interview.sde.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/combinations/
public class GenerateSubsetsSizeK {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = IntStream.rangeClosed(1, n).toArray();
        List<List<Integer>> solution = new ArrayList<>();

        for (int number : nums) {
            if (!solution.isEmpty()) {
                int solutionSize = solution.size();
                //For each new numbers, run to all existing solutions and this new number to the existing solution
                for (int i = 0; i < solutionSize; i++) {
                    List<Integer> aggregator = new ArrayList<>(solution.get(i));
                    if (aggregator.size() < k) {
                        aggregator.add(number);
                        solution.add(aggregator);
                    }
                }
            }
            //Add the new number as a single element solution
            solution.add(new ArrayList<>(Collections.singletonList(number)));
        }
        //Add empty solution
        solution.add(new ArrayList<>());
        return solution.stream().filter(i -> i.size() == k).collect(Collectors.toList());
    }

}
