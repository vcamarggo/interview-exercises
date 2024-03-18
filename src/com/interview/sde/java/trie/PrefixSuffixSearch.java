package com.interview.sde.java.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/prefix-and-suffix-search/
public class PrefixSuffixSearch {

    private final Trie trie;
    private final Map<String, Integer> wordsPosition;

    static class Trie {

        private final TrieNode root;

        static class TrieNode {
            String word;
            Map<Character, TrieNode> children;

            TrieNode() {
                this.children = new HashMap<>();
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            for (int i = word.length(); i >= 0; i--) {

                String tempWord = word.substring(i) + "#" + word;

                TrieNode current = root;
                for (char data : tempWord.toCharArray()) {
                    current = current.children.computeIfAbsent(data, k -> new TrieNode());
                    current.word = word;
                }
            }
        }

        public String search(String word) {
            TrieNode current = root;
            for (char data : word.toCharArray()) {
                if (!current.children.containsKey(data)) {
                    return null;
                }
                current = current.children.get(data);
            }
            return current.word;
        }

    }

    public PrefixSuffixSearch(String[] words) {
        this.trie = new Trie();
        this.wordsPosition = new HashMap<>(words.length + 1);
        this.wordsPosition.put(null, -1);

        for (int i = 0; i < words.length; i++) {
            wordsPosition.put(words[i], i);
            trie.insert(words[i]);
        }
    }

    public int f(String prefix, String suffix) {
        return wordsPosition.get(trie.search(suffix + "#" + prefix));
    }

    public static void main(String[] args) {
        PrefixSuffixSearch pss = new PrefixSuffixSearch(new String[]{"apple"});
        System.out.println(pss.f("a", "le")); //0
        System.out.println(pss.f("b", "e")); //-1
    }
}
