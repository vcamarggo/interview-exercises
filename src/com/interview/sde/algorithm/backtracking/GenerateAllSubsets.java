package com.interview.sde.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class GenerateAllSubsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{4, 1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();

        for (int number : nums) {
            if (!solution.isEmpty()) {
                int solutionSize = solution.size();
                //For each new numbers, run to all existing solutions and and this new number to the existing solution
                for (int i = 0; i < solutionSize; i++) {
                    List<Integer> aggregator = new ArrayList<>(solution.get(i));
                    aggregator.add(number);
                    solution.add(aggregator);
                }
            }
            //Add the new number as a single element solution
            solution.add(new ArrayList<>(Collections.singletonList(number)));
        }
        //Add empty solution
        solution.add(new ArrayList<>());
        return solution;
    }


}
