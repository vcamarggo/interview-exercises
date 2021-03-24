package com.interview.sde.hackerrank.algorithm.arrays;

import java.util.*;

//https://leetcode.com/problems/subsets/
public class GenerateAllPermutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums, nums.length - 1);
    }

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
        return solution;
    }


}
