package com.interview.sde.hackerrank.algorithm.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/palindrome-pairs/
//Timeout
public class PalindromePair {


    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> solution = new ArrayList<>();
        Map<String, Boolean> isPalindrome = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    String newString = words[i] + words[j];
                    if (!isPalindrome.containsKey(newString)) {
                        isPalindrome.put(newString, isPalindrome(newString));
                    }
                    if (isPalindrome.get(newString)) {
                        solution.add(List.of(i, j));
                    }
                }
            }
        }
        return solution;
    }


    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"bat", "tab", "cat", "ovo", ""}));
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
//        System.out.println(palindromePairs(new String[]{"a", ""}));
    }

}
