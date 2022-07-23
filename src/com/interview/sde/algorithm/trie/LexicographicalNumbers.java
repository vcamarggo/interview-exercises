package com.interview.sde.algorithm.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/lexicographical-numbers/
public class LexicographicalNumbers {
    private final TrieNode trie = new TrieNode();

    static class TrieNode {

        private String value;
        private boolean isWord;
        private final Map<Character, TrieNode> children;

        TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
        }

        void insert(String s) {
            TrieNode current = this;
            for (Character c : s.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new TrieNode());
            }
            current.value = s;
            current.isWord = true;
        }

        List<Integer> getWordsPreOrder() {
            return getWordsPreOrder(this);
        }

        private List<Integer> getWordsPreOrder(TrieNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            if (root.isWord) {
                result.add(Integer.parseInt(root.value));
            }
            for (TrieNode node : root.children.values()) {
                result.addAll(getWordsPreOrder(node));
            }
            return result;
        }
    }

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= n; i++) {
            trie.insert(String.valueOf(i));
        }
        return trie.getWordsPreOrder();
    }
}
