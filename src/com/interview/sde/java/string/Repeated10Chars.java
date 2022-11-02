package com.interview.sde.java.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/repeated-dna-sequences/
public class Repeated10Chars {

    public static void main(String[] args) {
        new Repeated10Chars().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> foundWords = new HashSet<>();

        StringBuilder slidingWindowChars = new StringBuilder(s);

        for (int i = 0; i + 9 < s.length(); i++) {
            String tenChars = slidingWindowChars.substring(i, i + 10);
            if (foundWords.contains(tenChars) && !result.contains(tenChars)) {
                result.add(tenChars);
            } else {
                foundWords.add(tenChars);
            }
        }

        return new ArrayList<>(result);
    }
}
