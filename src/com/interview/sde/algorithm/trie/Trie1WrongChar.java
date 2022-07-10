package com.interview.sde.algorithm.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-magic-dictionary/
public class Trie1WrongChar {

    static class TrieTree {

        TrieNode root = new TrieNode(' ');

        public void insert(String s) {
            TrieNode current = root;
            for (char c : s.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new TrieNode(c));
            }
            current.isWord = true;
            current.fullWord = s;
        }

        //Allow max 1 wrong character and still return found.
        // E.g. Trie has hello and hollo, but would still return true for hallo because it has only 1 wrong char
        public boolean searchWithMax1WrongChar(String searchWord, int beginIndex, TrieTree.TrieNode root, boolean usedWildcard) {
            for (int i = beginIndex; i < searchWord.length(); i++) {
                char data = searchWord.charAt(i);
                //Use the boolean "usedWildcard" as a single-use possibility to ignore 1 char
                if (!usedWildcard) {
                    for (TrieTree.TrieNode child : root.children.values()) {
                        if (searchWithMax1WrongChar(searchWord, i + 1, child, true)) {
                            return true;
                        }
                    }
                }
                if (!root.children.containsKey(data)) {
                    return false;
                }
                root = root.children.get(data);
            }
            return root.isWord && !root.fullWord.equals(searchWord);
        }

        public boolean searchWithMax1WrongChar(String searchWord) {
            return searchWithMax1WrongChar(searchWord, 0, root, false);
        }

        static class TrieNode {
            char val;
            boolean isWord;
            String fullWord;
            Map<Character, TrieNode> children;

            public TrieNode(char val) {
                this.val = val;
                this.isWord = false;
                this.children = new HashMap<>();
            }
        }
    }

    TrieTree trie;

    public Trie1WrongChar() {

    }

    public void buildDict(String[] dictionary) {
        this.trie = new TrieTree();
        for (String word : dictionary) {
            trie.insert(word);
        }

    }

    public boolean search(String searchWord) {
        return trie.searchWithMax1WrongChar(searchWord);
    }


    public static void main(String[] args) {
        Trie1WrongChar md = new Trie1WrongChar();
        md.buildDict(new String[]{"hello", "hallo", "leetcode"});
        System.out.println(md.search("hello"));
        System.out.println(md.search("hollo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("leetcoded"));
    }
}
