package com.interview.sde.java.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/largest-time-for-given-digits/
public class LargestTime {
    public String largestTimeFromDigits(int[] arr) {
        int maxValidMinutes = -1;
        for (List<Integer> A : permute(arr, arr.length - 1)) {
            int hour = A.get(0) * 10 + A.get(1);
            int minute = A.get(2) * 10 + A.get(3);

            if (hour < 24 && minute < 60) {
                maxValidMinutes = Math.max(hour * 60 + minute, maxValidMinutes);
            }
        }

        if (maxValidMinutes == -1) {
            return "";
        }

        return String.format("%02d:%02d", maxValidMinutes / 60, maxValidMinutes % 60);
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
        return new ArrayList<>(solution);
    }
}
