package com.interview.sde.java.string;

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
            anagramGrouping.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagramGrouping.values());
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagrams(new String[]{""});
        groupAnagrams(new String[]{"a"});
    }
}
