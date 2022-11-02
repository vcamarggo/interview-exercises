package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
public class NumberOfGoodStrings {
    public int numSplits(String s) {
        int count = 0;

        HashMap<Character, Integer> rightUnique = new HashMap<>();
        Set<Character> leftUnique = new HashSet<>();

        for (int i = 1; i < s.length(); i++) {
            //prefill the right unique chars with all chars counted
            rightUnique.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 1; i < s.length(); i++) {
            //add the previous char to the list of unique on the left
            leftUnique.add(s.charAt(i - 1));


            if (leftUnique.size() == rightUnique.size()) {
                count++;
            }

            //remove (decrease) the current char from the list of unique right as it will be added to left on next iteration
            rightUnique.compute(s.charAt(i), (k, v) -> v == 1 ? null : v - 1);
        }

        return count;
    }

}
