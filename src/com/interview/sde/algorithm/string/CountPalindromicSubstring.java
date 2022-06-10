package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/palindromic-substrings/
public class CountPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(countSubstrings("cbbd"));
        System.out.println(countSubstrings("babad"));
        System.out.println(countSubstrings("a"));
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings(""));
    }

    public static int countSubstrings(String s) {
        char[] stringAsChar = s.toCharArray();
        int count = 0;

        for (int i = 0; i < stringAsChar.length; i++) {
            //first try: expand the palindrome over an index i like in "aba" or "cabac"
            for (int left = i, right = i; left >= 0 && right < stringAsChar.length && stringAsChar[left] == stringAsChar[right]; left--, right++) {
                count++;
            }

            //second try: expand the palindrome over a pair i,i+1 like in "bb" or "aabbaa"
            for (int left = i, right = i + 1; left >= 0 && right < stringAsChar.length && stringAsChar[left] == stringAsChar[right]; left--, right++) {
                count++;
            }
        }
        return count;
    }

}
