package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {

    Integer[][] memo;

    public int longestPalindromeSubseq(String s) {
        memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length() - 1);
    }

    private int longestPalindromeSubseq(String s, int start, int end) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return memo[start][end] = 2 + longestPalindromeSubseq(s, start + 1, end - 1);
        }

        return memo[start][end] = Math.max(longestPalindromeSubseq(s, start + 1, end), longestPalindromeSubseq(s, start, end - 1));
    }
}
