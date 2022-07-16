package com.interview.sde.algorithm.disjointset;

import java.util.*;

//https://leetcode.com/problems/smallest-string-with-swaps/
public class SmallestStringWithSwaps {
    public static class DisjointSet {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> ranks = new HashMap<>();

        DisjointSet(int size) {
            for (int i = 0; i < size; i++) {
                parents.put(i, i);
                ranks.put(i, 1);
            }
        }

        void union(Integer a, Integer b) {
            int parentA = findParent(a);
            int parentB = findParent(b);
            if (parentA != parentB) {
                if (ranks.get(parentA) > ranks.get(parentB)) {
                    parents.put(parentB, parentA);
                    ranks.compute(parentA, (key, value) -> value + ranks.get(parentB));
                } else {
                    parents.put(parentA, parentB);
                    ranks.compute(parentB, (key, value) -> value + ranks.get(parentA));
                }
            }
        }

        int findParent(int i) {
            while (i != parents.get(i)) {
                parents.put(i, i = parents.get(i));
            }
            return parents.get(i);
        }

        Collection<List<Integer>> generateIndexList() {
            Map<Integer, List<Integer>> indexes = new HashMap<>();
            for (int i = 0; i < parents.size(); i++) {
                indexes.computeIfAbsent(findParent(i), k -> new ArrayList<>()).add(i);
            }
            return indexes.values();
        }

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSet sets = new DisjointSet(s.length());

        for (List<Integer> pair : pairs) {
            sets.union(pair.get(0), pair.get(1));
        }

        char[] solution = new char[s.length()];

        for (List<Integer> indexes : sets.generateIndexList()) {
            List<Character> characters = new ArrayList<>();
            for (Integer i : indexes) {
                characters.add(s.charAt(i));
            }

            Collections.sort(characters);

            for (int i = 0; i < indexes.size(); i++) {
                solution[indexes.get(i)] = characters.get(i);
            }
        }
        return new String(solution);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", List.of()));
        System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2))));

    }
}
