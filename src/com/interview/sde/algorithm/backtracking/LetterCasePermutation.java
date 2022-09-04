package com.interview.sde.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {


    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    static List<String> letterCasePermutation(String s) {
        return getPermutation(s, "", 0);
    }

    public static List<String> getPermutation(String s, String builder, int startFrom) {
        if (s.length() == builder.length()) {
            return List.of(builder);
        }

        List<String> solution = new ArrayList<>();
        for (int i = startFrom; i < s.length(); i++) {
            if (s.charAt(i) > 58) {
                char c = s.charAt(i);
                solution.addAll(getPermutation(s, builder + Character.toUpperCase(c), i + 1));
                solution.addAll(getPermutation(s, builder + Character.toLowerCase(c), i + 1));
            } else {
                builder += s.charAt(i);
                if (s.length() == builder.length()) {
                    solution.add(builder);
                }
            }
        }
        return solution;
    }

}
