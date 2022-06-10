package com.interview.sde.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/permutations-ii/
public class GenerateAllPermutationsII {
    public static List<List<Integer>> permute(int[] nums, int size) {
        List<List<Integer>> solution = new ArrayList<>();

        if (size < 0) {
            //Dumped because Java does not create an empty list with an empty list. TODO - understand why :)
            solution.add(new ArrayList<>(Collections.emptyList()));
            return solution;
        }

        int number = nums[size];

        List<List<Integer>> temporaryPermute = permute(nums, size - 1);

        for (List<Integer> permutation : temporaryPermute) {
            for (int i = 0; i <= permutation.size(); i++) {
                //Clone to dereferrence
                List<Integer> clone = new ArrayList<>(permutation);
                clone.add(i, number);
                solution.add(clone);
            }
        }
        return new ArrayList<>(new HashSet<>(solution));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums, nums.length - 1);
    }


}
