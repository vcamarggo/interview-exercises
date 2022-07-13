package com.interview.sde.algorithm.dynamicprogramming;

import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1/

public class LongestCommonSubstring {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the longestCommonSubsequence function below.
    static int longestCommonSubstring(char[] a1, char[] a2) {
        int[][][] lcsCounter = new int[a1.length + 1][a2.length + 1][1];

        int max = 0;
        for (int s1Index = 1; s1Index < lcsCounter.length; s1Index++) {
            for (int s2Index = 1; s2Index < lcsCounter[0].length; s2Index++) {
                if (a1[s1Index - 1] == (a2[s2Index - 1])) {
                    lcsCounter[s1Index][s2Index][0] = lcsCounter[s1Index - 1][s2Index - 1][0] + 1;
                }
                max = Math.max(max, lcsCounter[s1Index][s2Index][0]);
            }
        }

        return max;
    }
}

