package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/java-anagrams/problem
public class JavaAnagrams {


    static void populateHashMap(java.util.HashMap<Character, Integer> hashMap, String str) {
        for (int i = 0; i < str.length(); i++) {
            Character key = Character.toLowerCase(str.charAt(i));
            hashMap.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        HashMap<Character, Integer> counterMapA = new HashMap<>();
        HashMap<Character, Integer> counterMapB = new HashMap<>();

        populateHashMap(counterMapA, a);
        populateHashMap(counterMapB, b);

        for (Map.Entry<Character, Integer> entry : counterMapA.entrySet()) {
            if (!counterMapB.containsKey(entry.getKey()) || !counterMapB.get(entry.getKey()).equals(entry.getValue()))
                return false;
        }
        return true;
    }


}
