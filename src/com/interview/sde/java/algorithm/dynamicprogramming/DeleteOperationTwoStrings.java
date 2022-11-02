package com.interview.sde.algorithm.dynamicprogramming;

//https://leetcode.com/problems/delete-operation-for-two-strings/
public class DeleteOperationTwoStrings {
    public int minDistance(String word1, String word2) {
        return  word1.length() + word2.length() - (2 * longestCommonSubsequenceSize(word1.toCharArray(), word2.toCharArray()));
    }

    int longestCommonSubsequenceSize(char[] a1, char[] a2) {
        int[][] lcsCounter = new int[a1.length + 1][a2.length + 1];

        for (int s1Index = 1; s1Index < lcsCounter.length; s1Index++) {
            for (int s2Index = 1; s2Index < lcsCounter[0].length; s2Index++) {
                if (a1[s1Index - 1] == a2[s2Index - 1]) {
                    lcsCounter[s1Index][s2Index] = lcsCounter[s1Index - 1][s2Index - 1] + 1;
                } else {
                    lcsCounter[s1Index][s2Index] = Math.max(lcsCounter[s1Index - 1][s2Index], lcsCounter[s1Index][s2Index - 1]);
                }
            }
        }

        return lcsCounter[a1.length][a2.length];
    }
}
