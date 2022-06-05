package com.interview.sde.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    private final Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        new WordBreak().wordBreak("leetcode", List.of("leet", "code"));
    }

    boolean wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 0) {
            memo.put(s, true);
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (wordDict.contains(sub) && wordBreak(s.substring(i), wordDict)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
