package com.interview.sde.java.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

//https://leetcode.com/problems/sort-characters-by-frequency/
public class SortByFrequency {
    public String frequencySort(String s) {

        String[] chars = s.split("");

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String charr : chars) {
            hashMap.compute(charr, (k, v) -> v == null ? 1 : v + 1);
        }

        return Arrays.stream(chars).sorted((c1, c2) -> {
            int comp = hashMap.get(c2).compareTo(hashMap.get(c1));
            if (comp == 0) {
                return c1.compareTo(c2);
            }
            return comp;
        }).collect(Collectors.joining());
    }
}
