package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/word-pattern
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> wordMap = new HashMap<>();
        Map<String, Character> patternMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (!wordMap.getOrDefault(c, words[i]).equals(words[i])) {
                return false;
            } else if (!patternMap.getOrDefault(words[i], c).equals(c)) {
                return false;
            }
            wordMap.putIfAbsent(c, words[i]);
            patternMap.putIfAbsent(words[i], c);
        }

        return true;
    }
}
