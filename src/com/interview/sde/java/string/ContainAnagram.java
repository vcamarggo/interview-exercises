package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/permutation-in-string/
public class ContainAnagram {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eioo"));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Letters = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Letters.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        Map<Character, Integer> s2Anagram = new HashMap<>();

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            s2Anagram.clear();
            for (int j = 0; j < s1.length(); j++) {
                char key = s2.charAt(i + j);
                s2Anagram.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
            if (s1Letters.equals(s2Anagram)) {
                return true;
            }
        }
        return false;
    }
}
