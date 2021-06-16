package com.interview.sde.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree
public class TrieTree {
    static class Trie {

        TrieNode root;

        static class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> children;

            TrieNode(boolean isWord) {
                this.isWord = isWord;
                children = new HashMap<>();
            }
        }


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode(false);
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode current = root;
            for (char data : word.toCharArray()) {
                if (!current.children.containsKey(data)) {
                    current.children.put(data, new TrieNode(false));
                }
                current = current.children.get(data);
            }
            current.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchNode(word);
            return node != null && node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchNode(prefix) != null;
        }

        private TrieNode searchNode(String prefix) {
            TrieNode current = root;
            for (char data : prefix.toCharArray()) {
                if (!current.children.containsKey(data)) {
                    return null;
                }
                current = current.children.get(data);
            }
            return current;
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("ap"));        // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }

}
