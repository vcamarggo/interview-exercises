package com.interview.sde.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class MissingNumberInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        List<Integer> solution = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            if (!unique.contains(i)) {
                solution.add(i);
            }
        }
        return solution;
    }
}
