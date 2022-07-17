package com.interview.sde.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    Map<String, Boolean> isPalindromeMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("a"));
        System.out.println(new PalindromePartitioning().partition(""));
        System.out.println(new PalindromePartitioning().partition("cbbbcc"));
    }

    public List<List<String>> partition(String s, List<String> partialPartition) {
        List<List<String>> solution = new ArrayList<>();
        if (s.length() == 0) {
            solution.add(new ArrayList<>(partialPartition));
            return solution;
        }

        for (int i = 1; i <= s.length(); i++) {
            String subS = s.substring(0, i);
            if (isPalindromeMap.computeIfAbsent(subS, key -> isPalindrome(subS))) {
                partialPartition.add(subS);
                int subSIndex = partialPartition.size() - 1;
                solution.addAll(partition(s.substring(i), partialPartition));
                partialPartition.remove(subSIndex);
            }
        }

        return solution;
    }

    boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        return partition(s, new ArrayList<>());
    }
}
