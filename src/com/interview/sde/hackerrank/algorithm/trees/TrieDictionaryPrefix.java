package com.interview.sde.hackerrank.algorithm.trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/replace-words/solution/
public class TrieDictionaryPrefix {

    static class TrieNode {
        boolean isWord;
        String data;
        Map<Character, TrieNode> children;

        TrieNode(String data, boolean isWord) {
            this.data = data;
            this.isWord = isWord;
            children = new HashMap<>();
        }
    }

    private static TrieNode searchNode(TrieNode root, String prefix) {
        TrieNode current = root;
        for (char data : prefix.toCharArray()) {
            if (!current.children.containsKey(data)) {
                return null;
            } else if (current.children.get(data).isWord) {
                return current.children.get(data);
            }
            current = current.children.get(data);
        }
        return current;
    }

    private static void insert(TrieNode root, String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            if (!current.children.containsKey(key.charAt(i))) {
                current.children.put(key.charAt(i), new TrieNode(key.substring(0, i + 1), false));
            }
            current = current.children.get(key.charAt(i));
        }
        current.isWord = true;
    }


    static String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode(" ", false);
        StringBuilder solution = new StringBuilder();
        dictionary.forEach(word -> insert(root, word));

        for (String word : sentence.split(" ")) {
            TrieNode node = searchNode(root, word);
            if (node != null) {
                solution.append(node.data);
            } else {
                solution.append(word);
            }
            solution.append(" ");
        }

        return solution.toString().trim();
    }

    public static void main(String[] args) {
//        System.out.println(replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        assert replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery").equals("the cat was rat by the bat");

//        System.out.println(replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
        assert replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs").equals("a a b c");

//        System.out.println(replaceWords(List.of("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
        assert replaceWords(List.of("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa").equals("a a a a a a a a bbb baba a");

//        System.out.println(replaceWords(List.of("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery"));
        assert replaceWords(List.of("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery").equals("the cat was rat by the bat");

//        System.out.println(replaceWords(List.of("ac", "ab"), "it is abnormal that this solution is accepted"));
        assert replaceWords(List.of("ac", "ab"), "it is abnormal that this solution is accepted").equals("it is ab that this solution is ac");

    }
}
