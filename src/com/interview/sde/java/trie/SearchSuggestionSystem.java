package com.interview.sde.java.trie;

import java.util.*;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionSystem {
    static class Trie {

        List<String> words;
        Map<Character, Trie> children;

        Trie() {
            this.children = new HashMap<>();
            this.words = new ArrayList<>();
        }

        void insert(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                root = root.children.computeIfAbsent(c, k -> new Trie());
                if (root.words.size() < 3) {
                    root.words.add(word);
                }
            }
        }

        List<String> search(String prefix) {
            Trie root = this;

            for (char c : prefix.toCharArray()) {
                if (root.children.containsKey(c)) {
                    root = root.children.get(c);
                } else {
                    return Collections.emptyList();
                }
            }
            return root.words;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();

        Arrays.sort(products);

        List<List<String>> suggestions = new ArrayList<>();

        for (String product : products) {
            root.insert(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            suggestions.add(root.search(searchWord.substring(0, i + 1)));
        }

        return suggestions;
    }

    public static void main(String[] args) {
        System.out.println(new SearchSuggestionSystem().suggestedProducts(new String[]{"havana"}, "tatiana"));
        System.out.println(new SearchSuggestionSystem().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(new SearchSuggestionSystem().suggestedProducts(new String[]{"havana"}, "mouse"));
        System.out.println(new SearchSuggestionSystem().suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(new SearchSuggestionSystem().suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
    }
}
