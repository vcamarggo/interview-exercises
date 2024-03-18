package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/3sum/
public class SumThree {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).sorted().boxed().toList();
        Set<List<Integer>> solution = new HashSet<>();

        for (int i = 0; i < numsList.size(); i++) {
            Set<Integer> s = new HashSet<>();
            int currNum = -numsList.get(i);

            for (int j = i + 1; j < numsList.size(); j++) {
                if (s.contains(currNum - numsList.get(j))) {
                    solution.add(List.of(numsList.get(i), numsList.get(j), currNum - numsList.get(j)));
                }
                s.add(numsList.get(j));
            }
        }

        return new ArrayList<>(solution);
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
