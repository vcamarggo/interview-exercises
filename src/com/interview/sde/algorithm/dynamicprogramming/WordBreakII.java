package com.interview.sde.algorithm.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-break-ii/
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> wordBreak = wordBreak(s, wordDict, new Stack<>());
        List<String> solution = new ArrayList<>();
        for(List<String> sentence : wordBreak){
            solution.add(String.join(" ", sentence));
        }
        return solution.stream().sorted().collect(Collectors.toList());
    }

    List<List<String>> wordBreak(String s, List<String> wordDict, Stack<String> tempSolution) {
        List<List<String>> solution = new ArrayList<>();
        if (s.length() == 0) {
            solution.add(new ArrayList<>(tempSolution));
            return solution;
        }
        for (String word : wordDict){
            if(s.startsWith(word)){
                tempSolution.push(word);
                solution.addAll(wordBreak(s.substring(word.length()), wordDict, tempSolution));
                tempSolution.pop();
            }
        }
        return solution;
    }
}
