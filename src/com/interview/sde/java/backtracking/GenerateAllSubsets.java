package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class GenerateAllSubsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{4, 1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        solution.add(new ArrayList<>());

        for (int number : nums) {
            int solutionSize = solution.size();
            //For each new numbers, run to all existing solutions and add this new number to the existing solution
            for (int i = 0; i < solutionSize; i++) {
                List<Integer> aggregator = new ArrayList<>(solution.get(i));
                aggregator.add(number);
                solution.add(aggregator);
            }
        }
        return solution;
    }


}
