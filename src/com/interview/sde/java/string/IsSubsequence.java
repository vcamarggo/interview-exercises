package com.interview.sde.java.string;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == s.length();
    }
}
