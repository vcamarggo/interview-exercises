package com.interview.sde.java.dynamicprogramming;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
    }

    public static String longestPalindrome(String s) {
        char[] stringAsChar = s.toCharArray();
        String longest = "";

        for (int i = 0; i < stringAsChar.length; i++) {
            //first try: expand the palindrome over an index i like in "aba" or "cabac"
            for (int left = i, right = i; left >= 0 && right < stringAsChar.length && stringAsChar[left] == stringAsChar[right]; left--, right++) {
                if (longest.length() < right - left + 1) {
                    longest = s.substring(left, right + 1);
                }
            }
            //second try: expand the palindrome over a pair i,i+1 like in "bb" or "aabbaa"
            for (int left = i, right = i + 1; left >= 0 && right < stringAsChar.length && stringAsChar[left] == stringAsChar[right]; left--, right++) {
                if (longest.length() < right - left + 1) {
                    longest = s.substring(left, right + 1);
                }
            }
        }
        return longest;
    }

}
