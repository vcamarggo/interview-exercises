package com.interview.sde.java.string;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (prefix.length() > strs[i].length()) {
                String temp = prefix;
                prefix = strs[i];
                strs[i] = temp;
            }
            int minSize = prefix.length();
            for (int j = 0; j < minSize; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    prefix = prefix.substring(0, j);
                    if (prefix.isEmpty()) return "";
                    break;
                }
            }
        }

        return prefix;
    }

}
