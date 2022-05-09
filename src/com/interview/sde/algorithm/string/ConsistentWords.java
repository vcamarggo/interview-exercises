package com.interview.sde.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

//https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class ConsistentWords {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistent = words.length;

        HashSet<Character> allowedLetters = new HashSet<>();
        for(Character letter : allowed.toCharArray()){
            allowedLetters.add(letter);
        }

        for(String word : words){
            if(word.chars().anyMatch(c -> !allowedLetters.contains((char)c))){
                    consistent--;
                    break;
            }
        }
        return consistent;
    }
}
