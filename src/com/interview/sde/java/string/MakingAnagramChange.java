package com.interview.sde.java.string;

import java.util.HashMap;

public class MakingAnagramChange {

    // Complete the makingAnagrams function below.
    // This function counts number of replacements to s2 chars to make it anagram of s1
    public int minSteps(String s1, String s2) {
        HashMap<Character, Integer> charInStringOccurrenceA = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            charInStringOccurrenceA.put(c, charInStringOccurrenceA.getOrDefault(c, 0) + 1);
        }
        int counter = s2.length();

        for (Character c : s2.toCharArray()) {
            if (charInStringOccurrenceA.containsKey(c)) {
                int occurrences = charInStringOccurrenceA.get(c);
                if (occurrences > 0) {
                    charInStringOccurrenceA.put(c, occurrences - 1);
                    counter -= 1;
                }
            }
        }

        return counter;
    }
}
