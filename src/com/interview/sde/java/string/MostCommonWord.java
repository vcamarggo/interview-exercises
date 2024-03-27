package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/most-common-word
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banished = new HashSet<>(banned.length);
        for(String str : banned){
            banished.add(str.toLowerCase());
        }

        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        for(String word : words){
            if(!banished.contains(word))
                wordCount.compute(word, (k, v)  -> (v == null) ? 1 : v + 1);
        }

        int max = 0;
        String maxWord = "";

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        return maxWord;
    }

}
