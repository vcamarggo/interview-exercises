package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/adding-spaces-to-a-string/
public class AddSpaceToString {
    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

    static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < spaces.length; i++) {
            sb.insert(spaces[i] + i, " ");
        }
        return sb.toString();
    }
}
