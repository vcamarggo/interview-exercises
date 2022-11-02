package com.interview.sde.algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    List<String> topKFrequent(String[] words, int k) {
        //Using TreeMap to keep lexicographical ordering on keys
        Map<String, Integer> stringCounter = new TreeMap<>();
        for (String word : words) {
            stringCounter.put(word, stringCounter.getOrDefault(word, 0) + 1);
        }
        List<String> kMostFrequent = new ArrayList<>(stringCounter.keySet());
        //Sort them based on frequency, treemap will keep lexicographical ordering for counting ties
        kMostFrequent.sort(((o1, o2) -> stringCounter.get(o2).compareTo(stringCounter.get(o1))));
        return kMostFrequent.subList(0, k);
    }
}
