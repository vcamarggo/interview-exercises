package com.interview.sde.java.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[][] chars = new int[words.length][26];

        for (int i = 0 ; i < words.length ; i++) {
            for (Character c : words[i].toCharArray()) {
                chars[i][c - 'a']++;
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int word = 0; word < words.length; word++) {
                min = Math.min(min, chars[word][i]);
            }
            while (min > 0) {
                result.add(Character.toString('a' + i));
                min--;
            }
        }

        return result;
    }
}
