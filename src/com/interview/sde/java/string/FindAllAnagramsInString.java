package com.interview.sde.java.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {
    static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCharCounter = new HashMap<>(p.length());
        for (Character c : p.toCharArray()) {
            pCharCounter.put(c, pCharCounter.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sCharCounter = new HashMap<>(p.length());
        List<Integer> anagrams = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sCharCounter.put(c, sCharCounter.getOrDefault(c, 0) + 1);
            if (i >= p.length() - 1) {
                int firstIndexOfSubstring = i + 1 - p.length();
                if (sCharCounter.equals(pCharCounter)) {
                    anagrams.add(firstIndexOfSubstring);
                }
                sCharCounter.computeIfPresent(s.charAt(firstIndexOfSubstring), (key, value) -> value == 1 ? null : value - 1);
            }
        }
        return anagrams;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
