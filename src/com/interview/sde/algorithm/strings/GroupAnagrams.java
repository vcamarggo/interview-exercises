package com.interview.sde.algorithm.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {


    static List<List<String>> groupAnagrams(String[] strs) {
        final int OFFSET = 97;
        Map<String, List<String>> anagramGrouping = new HashMap<>();

        for (String word : strs) {
            int[] anagramKeyCounter = new int[26];
            for (Character c : word.toCharArray()) {
                anagramKeyCounter[((int) c - OFFSET)] += 1;
            }
            StringBuilder key = new StringBuilder();
            for (int keyCounter : anagramKeyCounter) {
                key.append('#').append(keyCounter);
            }
            List<String> anagrams = anagramGrouping.getOrDefault(key.toString(), new ArrayList<>());
            anagrams.add(word);
            anagramGrouping.put(key.toString(), anagrams);
        }
        return new ArrayList<>(anagramGrouping.values());
    }

    public static void main(String[] args) {
        //groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagrams(new String[]{""});
        groupAnagrams(new String[]{"a"});
    }
}
