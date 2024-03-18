package com.interview.sde.java.backtracking;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/permutations/
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
                //Clone to dereference
                List<Integer> clone = new ArrayList<>(permutation);
                clone.add(i, number);
                solution.add(clone);
            }
        }
        //Remove the sorting part if you want to submit this on leetcode, I've added to try ordering of arrays
        return solution.stream().sorted(Comparator.comparing(Object::toString)).collect(Collectors.toList());
    }


    public static List<List<Integer>> permute2(int[] nums) {
        return getPermutation(nums, new ArrayList<>(), new HashMap<>(nums.length));
    }

    //Another approach to solve
    public static List<List<Integer>> getPermutation(int[] nums, List<Integer> s, Map<Integer, Boolean> vis) {
        List<List<Integer>> solution = new ArrayList<>();
        if (s.size() == nums.length) {
            solution.add(new ArrayList<>(s));
            return solution;
        }

        for (int i : nums) {
            if (!vis.getOrDefault(i, false)) {
                vis.put(i, true);
                s.add(i);
                solution.addAll(getPermutation(nums, s, vis));
                s.remove(s.size() - 1);
                vis.put(i, false);
            }
        }
        return solution;
    }


}
