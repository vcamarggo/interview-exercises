package com.interview.sde.java.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
public class ReverseEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> solution = new ArrayList<>();

        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    solution.add(Arrays.asList(x, y));
                    break;
                }
            }
        }
        return solution;
    }

    private interface CustomFunction {
        int f(int x, int y);
    }
}
