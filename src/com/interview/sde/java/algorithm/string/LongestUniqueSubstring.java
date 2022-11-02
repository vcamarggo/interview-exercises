package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/longest-substring-without-repeating-characters
public class LongestUniqueSubstring {

    static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int startingIndex = 0;
        int endIndex = 0;
        int i = 0;
        String substring = s.substring(startingIndex, endIndex);
        while (i < s.length()) {
            String charAt = s.substring(i, i + 1);
            if (substring.contains(charAt)) {
                startingIndex = s.indexOf(charAt, startingIndex) + 1;
                endIndex = i + 1;
                substring = s.substring(startingIndex, endIndex);
            } else {
                endIndex++;
                substring = substring.concat(charAt);
            }
            maxLength = Math.max(maxLength, endIndex - startingIndex);
            i++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbtablud"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
