package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/reverse-words-in-a-string
public class ReverseStrings {
    public String reverseWords(String s) {
        String[] tokens = s.split("(\\s+)");
        for (int i = 0; i < tokens.length / 2; i++) {
            String temp = tokens[i].trim();
            tokens[i] = tokens[(tokens.length - 1) - i].trim();
            tokens[(tokens.length - 1) - i] = temp;
        }
        return String.join(" ", tokens).trim();
    }
}
