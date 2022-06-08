package com.interview.sde.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-word-in-dictionary/
public class LongestWordInDictionary {

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionary().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(new LongestWordInDictionary().longestWord(new String[]{"w","wo","wor","worl","world"}));
    }

    public String longestWord(String[] words) {
        final Map<String, Boolean> prefixList = new HashMap<>();

        String longestString = "";
        //Sort the strings lexicographically
        Arrays.sort(words, String::compareTo);

        for (String word : words) {
            prefixList.put(word, false);

            //If word is a single letter or the prefix word existed, add the current word and possibly update longestString
            if (word.length() == 1 || prefixList.getOrDefault(word.substring(0, word.length() - 1), false)) {
                prefixList.put(word, true);
                longestString = longestString.length() < word.length() ? word : longestString;
            }
        }
        return longestString;
    }
}
