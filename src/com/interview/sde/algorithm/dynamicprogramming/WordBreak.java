package com.interview.sde.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    private final Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
    }

    boolean wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 0) {
            memo.put(s, true);
            return true;
        }
        for (String word : wordDict){
            if(s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
