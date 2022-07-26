package com.interview.sde.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/combinations/
public class GenerateSubsetsSizeK {

    public static void main(String[] args) {
        System.out.println(new GenerateSubsetsSizeK().combine2(4, 2));
        System.out.println(new GenerateSubsetsSizeK().combine2(1, 1));
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> solution = new ArrayList<>();

        int[] lastUsedIndexForPosition = new int[k];

        //create the first solution
        for (int i = 1; i <= k; i++) {
            lastUsedIndexForPosition[i - 1] = i;
        }

        boolean hasChanges = n >= k;
        while (hasChanges) {
            hasChanges = false;

            //create solution from lastUsedIndexForPosition
            solution.add(Arrays.stream(lastUsedIndexForPosition).boxed().collect(Collectors.toList()));

            //calculate the index of the next change
            int changeIndex = k - 1;
            while (changeIndex >= 0 && lastUsedIndexForPosition[changeIndex] == n +1 - k + changeIndex) {
                changeIndex--;
            }

            //if index >= 0 update the lastUsedIndexForPosition
            if (changeIndex >= 0) {
                hasChanges = true;
                lastUsedIndexForPosition[changeIndex]++;
                for (int j = changeIndex + 1; j < k; j++) {
                    lastUsedIndexForPosition[j] = lastUsedIndexForPosition[changeIndex] + j - changeIndex;
                }
            }

        }
        return solution;
    }

}
