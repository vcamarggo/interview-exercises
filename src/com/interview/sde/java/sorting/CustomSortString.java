package com.interview.sde.java.sorting;

//https://leetcode.com/problems/custom-sort-string
public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[ch - 97]++;
        }

        StringBuilder ordered = new StringBuilder();

        for (char ch : order.toCharArray()) {
            while (counter[ch - 97] > 0) {
                ordered.append(ch);
                counter[ch - 97]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (counter[i] > 0) {
                ordered.append((char) (i + 97));
                counter[i]--;
            }
        }

        return ordered.toString();
    }

}
