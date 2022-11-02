package com.interview.sde.java.string;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharIndex {
    int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

}
