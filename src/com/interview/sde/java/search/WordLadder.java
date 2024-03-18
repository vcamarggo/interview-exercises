package com.interview.sde.java.search;

import java.util.*;

//https://leetcode.com/problems/word-ladder
public class WordLadder {

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        //System.out.println(ladderLength("hit", "cod", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        //System.out.println(ladderLength("talk", "tail", List.of("talk", "tons", "fall", "tail", "gale", "hall", "negs")));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> dictionary = new HashMap<>();
        char wildcard = '*';

        for (String word : wordList) {
            for (int i = 0; i < beginWord.length(); i++) {
                String key = word.substring(0, i) + wildcard + word.substring(i + 1);
                dictionary.computeIfAbsent(key, k-> new HashSet<>()).add(word);
            }
        }


        Queue<StringDepth> toProcess = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        toProcess.add(new StringDepth(beginWord, 1));
        visited.add(beginWord);

        while (!toProcess.isEmpty()) {
            StringDepth solutionTry = toProcess.poll();

            if (solutionTry.getWord().equals(endWord)) {
                return solutionTry.getDepth();
            }

            for (int i = 0; i < beginWord.length(); i++) {
                String key = solutionTry.getWord().substring(0, i) + wildcard + solutionTry.getWord().substring(i + 1);
                if (dictionary.containsKey(key)) {
                    for (String neighborWord : dictionary.get(key)) {
                        if (!visited.contains(neighborWord)) {
                            toProcess.add(new StringDepth(neighborWord, solutionTry.getDepth() + 1));
                        }
                    }
                    dictionary.remove(key);
                }
            }
        }

        return 0;
    }

    private static class StringDepth {
        String word;
         int depth;

        public StringDepth(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }

        public String getWord() {
            return word;
        }

        public int getDepth() {
            return depth;
        }
    }


}
