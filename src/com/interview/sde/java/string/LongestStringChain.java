package com.interview.sde.java.string;

import java.util.*;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {
    final static char WILDCARD = '*';

    public int longestStrChain(String[] words) {
        //Prioritize like a stack, since new included items will have larger depth and increase chance of maximizing max,
        //else, prioritize shorter words to increase the chance of longer sequences
        //note that lexicographical ordering is irrelevant for processing priority
        PriorityQueue<Node> toProcess = new PriorityQueue<>((o1, o2) -> {
            int diff = Integer.compare(o2.depth, o1.depth);
            if (diff == 0) {
                return Integer.compare(o1.word.length(), o2.word.length());
            }
            return diff;
        });

        //Order words based on their length because shorter words have more change of longer sequences
        Arrays.sort(words, (o1, o2) -> {
            int diff = Integer.compare(o1.length(), o2.length());
            if (diff == 0) {
                //Keep if reversed in case of same size to follow priority queue logic.
                //note that lexicographical ordering is irrelevant for same sized strings
                return String.CASE_INSENSITIVE_ORDER.compare(o2, o1);
            }
            return diff;
        });

        Map<String, Set<String>> dictionary = generateDictionaryAndProcessingQueue(words, toProcess);
        Set<String> visited = new HashSet<>();

        int max = 0;

        while (!toProcess.isEmpty()) {
            Node node = toProcess.poll();
            String word = node.word;
            int depth = node.depth;
            max = Math.max(max, depth);
            if (!visited.contains(word)) {

                visited.add(word);

                for (int i = 0; i <= word.length(); i++) {
                    String key = generateNextKey(word, i);
                    if (dictionary.containsKey(key)) {
                        for (String neighborWord : dictionary.get(key)) {
                            if (!visited.contains(neighborWord)) {
                                toProcess.add(new Node(neighborWord, depth + 1));
                            }
                        }
                    }
                }
            }
        }

        return max;
    }

    private String generateCurrentKey(String word, int i) {
        return generateKey(word, i, i + 1);
    }

    private String generateNextKey(String word, int i) {
        return generateKey(word, i, i);
    }

    private String generateKey(String word, int endSubstring1, int startSubstring2) {
        return word.substring(0, endSubstring1) + WILDCARD + word.substring(startSubstring2);
    }

    private Map<String, Set<String>> generateDictionaryAndProcessingQueue(String[] words, PriorityQueue<Node> toProcess) {
        Map<String, Set<String>> dictionary = new HashMap<>();
        for (String word : words) {
            toProcess.add(new Node(word, 1));
            for (int i = 0; i < word.length(); i++) {
                String key = generateCurrentKey(word, i);
                dictionary.computeIfAbsent(key, k -> new HashSet<>()).add(word);
            }
        }
        return dictionary;
    }

    public static class Node {
        String word;
        Integer depth;

        public Node(String word, Integer depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}
