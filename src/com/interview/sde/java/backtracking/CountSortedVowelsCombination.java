package com.interview.sde.java.backtracking;

import java.util.Arrays;

//https://leetcode.com/problems/count-sorted-vowel-strings/
public class CountSortedVowelsCombination {
    public static void main(String[] args) {
        new CountSortedVowelsCombination().countVowelStrings(2);
    }
    public int countVowelStrings(int n) {
        int[] lastIndexForPosition = new int[n];

        int count = 1;

        boolean hasChanges = true;

        while(hasChanges){
            hasChanges = false;

            int changeIndex = n-1;
            while(changeIndex >= 0 && lastIndexForPosition[changeIndex] == 4){
                changeIndex--;
            }

            if (changeIndex >= 0) {
                hasChanges = true;
                count++;
                lastIndexForPosition[changeIndex]++;
                Arrays.fill(lastIndexForPosition, changeIndex + 1, n, lastIndexForPosition[changeIndex]);
            }
        }
        return count;
    }
}
