package com.interview.sde.java.string;

import java.util.Arrays;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class FindWordFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];

        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }

        return Arrays.stream(words).filter(s -> isGoodWord(s, charCount.clone())).map(String::length).mapToInt(Integer::intValue).sum();
    }

    private static boolean isGoodWord(String word, int[] wordCharCount) {
        for (char c : word.toCharArray()) {
            if (--wordCharCount[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
