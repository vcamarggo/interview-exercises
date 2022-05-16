package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class ReverseWordsStringsIII {
    static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word: words) {
            sb.append(new StringBuilder(word).reverse().append(" "));
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
