package com.interview.sde.algorithm.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/stream-of-characters/
public class SuffixTrie {

    TrieNode root = new TrieNode(' ');
    String query = "";

    static class TrieNode {
        char value;
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    public SuffixTrie(String[] words) {
        for (String word : words) {
            insert(word, root);
        }
    }

    private void insert(String word, TrieNode root) {
        for (int i = word.length() - 1; i >= 0; i--) {
            char key = word.charAt(i);
            root = root.children.computeIfAbsent(key, k -> new TrieNode(key));
        }
        root.isWord = true;
    }

    public boolean query(char letter) {
        query += letter;
        return search(query);
    }

    private boolean search(String query) {
        TrieNode root = this.root;
        for (int i = query.length() - 1; i >= 0; i--) {
            char c = query.charAt(i);
            if (!root.children.containsKey(c)) {
                return false;
            }
            root = root.children.get(c);
            if (root.isWord) {
                return true;
            }
        }
        return root.isWord;
    }

    public static void main(String[] args) {
        SuffixTrie st = new SuffixTrie(new String[]{"cd", "f", "kl"});
        st.query('a');
        st.query('b');
        st.query('c');
        st.query('d');
        st.query('e');
        st.query('f');
        st.query('g');
        st.query('h');
        st.query('i');
        st.query('j');
        st.query('k');
        st.query('l');
    }
}
