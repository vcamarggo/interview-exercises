package com.interview.sde.java.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-break-ii/
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new Stack<>()).stream()
                .map(sentence -> String.join(" ", sentence))
                .sorted()
                .collect(Collectors.toList());
    }

    List<List<String>> wordBreak(String s, List<String> wordDict, Stack<String> tempSolution) {
        List<List<String>> solution = new ArrayList<>();
        if (s.length() == 0) {
            solution.add(new ArrayList<>(tempSolution));
            return solution;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                tempSolution.push(word);
                solution.addAll(wordBreak(s.substring(word.length()), wordDict, tempSolution));
                tempSolution.pop();
            }
        }
        return solution;
    }
}
