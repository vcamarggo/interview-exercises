package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, new ArrayList<>(), 0);
    }

    // To make this faster, create a list<list<integer>> variable outside,
    // pass it as parameter and modify it when necessary
    // this will make the code faster, but the function non-pure
    static List<List<Integer>> combinationSum(int[] candidates, int target, List<Integer> tempSolution, int lastIndex) {
        List<List<Integer>> solution = new ArrayList<>();
        if (target == 0) {
            solution.add(new ArrayList<>(tempSolution));
        } else if (target > 0) {
            for (int i = lastIndex; i < candidates.length; i++) {
                tempSolution.add(candidates[i]);
                solution.addAll(combinationSum(candidates, target - candidates[i], tempSolution, i));
                tempSolution.remove(tempSolution.size() - 1);
            }
        }
        return solution;
    }

}
