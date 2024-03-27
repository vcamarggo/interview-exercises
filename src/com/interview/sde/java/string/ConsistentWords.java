package com.interview.sde.java.string;

import java.util.HashSet;

//https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class ConsistentWords {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistent = words.length;

        HashSet<Character> allowedLetters = new HashSet<>();
        for (Character letter : allowed.toCharArray()) {
            allowedLetters.add(letter);
        }

        for (String word : words) {
            for (Character letter : word.toCharArray()) {
                if (!allowedLetters.contains(letter)) {
                    consistent--;
                    break;
                }
            }
        }
        return consistent;
    }
}
