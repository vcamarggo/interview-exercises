package com.interview.sde.java.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class TrieWildcard {
    static class WordDictionary {
        TrieNode root;

        static class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> children;

            TrieNode(boolean isWord) {
                this.isWord = isWord;
                children = new HashMap<>();
            }
        }

        public WordDictionary() {
            root = new TrieNode(false);
        }

        public void addWord(String word) {
            TrieNode current = root;
            for (char data : word.toCharArray()) {
                if (!current.children.containsKey(data)) {
                    current.children.put(data, new TrieNode(false));
                }
                current = current.children.get(data);
            }
            current.isWord = true;
        }

        public boolean search(String word) {
            return search(word, root);
        }

        public boolean search(String word, TrieNode root) {
            for (int i = 0; i < word.length(); i++) {
                char data = word.charAt(i);
                if (data == '.') {
                    for (TrieNode child : root.children.values()) {
                        if (search(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                    return false;
                } else if (!root.children.containsKey(data)) {
                    return false;
                }
                root = root.children.get(data);
            }
            return root.isWord;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));

//        wordDictionary.addWord("an");
//        wordDictionary.addWord("add");

//        System.out.println(wordDictionary.search("a")); // return false
//        System.out.println(wordDictionary.search(".at")); // return false
        System.out.println();
//        System.out.println(wordDictionary.search("an.")); // return True
//        System.out.println(wordDictionary.search("a.d.")); // return True
        System.out.println();
//        System.out.println(wordDictionary.search("b.")); // return false
//        System.out.println(wordDictionary.search("a.d")); // return true
//        System.out.println(wordDictionary.search(".")); // return false


        //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
        //[[],[             "at"],    ["and"],  ["an"],    ["add"], ["a"],   [".at"], ["bat"],  [".at"], ["an."], ["a.d."],["b."],  ["a.d"],  ["."]]

    }
}
