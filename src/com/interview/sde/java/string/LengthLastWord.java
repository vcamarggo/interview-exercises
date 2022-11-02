package com.interview.sde.java.string;

//https://leetcode.com/problems/length-of-last-word/
public class LengthLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }
}
