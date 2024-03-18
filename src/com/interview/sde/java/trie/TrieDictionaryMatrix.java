package com.interview.sde.java.trie;

import java.util.*;

//https://leetcode.com/problems/word-search-ii/
public class TrieDictionaryMatrix {

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode(boolean isWord) {
            this.isWord = isWord;
            children = new HashMap<>();
        }
    }

    private static void insert(TrieNode root, String key) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            current = current.children.computeIfAbsent(key.charAt(i), k -> new TrieNode(false));
        }
        current.isWord = true;
    }


    public static List<String> findWords(char[][] board, String[] words) {

        final int ROWS = board.length;
        final int COLUMNS = board[0].length;

        TrieNode root = new TrieNode(false);

        for (String word : words) {
            insert(root, word);
        }

        Set<String> result = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean[][] visited = new boolean[ROWS][COLUMNS];
                Character key = board[row][column];
                if (root.children.containsKey(key)) {
                    TrieNode nextNode = root.children.get(key);
                    if (root.children.get(key).isWord) {
                        result.add(String.valueOf(key));
                    }
                    searchNodeNextLevel(board, row, column, visited, String.valueOf(board[row][column]), nextNode, result);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private static Set<String> searchNodeNextLevel(char[][] board, int row, int column, boolean[][] visited, String data, TrieNode root, Set<String> result) {

        int topRow = row - 1;
        int rightColumn = column + 1;
        int bottomRow = row + 1;
        int leftColumn = column - 1;

        visited[row][column] = true;
        //top
        if (topRow >= 0 && !visited[topRow][column]) {
            dfsInternal(board, topRow, column, data, root, result, visited);
        }

        //right
        if (rightColumn <= board[0].length - 1 && !visited[row][rightColumn]) {
            dfsInternal(board, row, rightColumn, data, root, result, visited);
        }

        //bottom
        if (bottomRow <= board.length - 1 && !visited[bottomRow][column]) {
            dfsInternal(board, bottomRow, column, data, root, result, visited);
        }

        //left
        if (leftColumn >= 0 && !visited[row][leftColumn]) {
            dfsInternal(board, row, leftColumn, data, root, result, visited);
        }
        visited[row][column] = false;

        return result;
    }

    private static void dfsInternal(char[][] board, int row, int column, String data, TrieNode root, Set<String> result, boolean[][] visited) {
        char c = board[row][column];
        String newData = data + c;
        //only search on valid paths - pruning the ones that are not in the path
        if (root.children.containsKey(c)) {
            TrieNode nextNode = root.children.get(c);
            if (nextNode.isWord) {
                result.add(newData);
            }
            //search the right path
            searchNodeNextLevel(board, row, column, visited, newData, nextNode, result);
        }
    }


    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{
                        new char[]{'o', 'a', 'a', 'n'},
                        new char[]{'e', 't', 'a', 'e'},
                        new char[]{'i', 'h', 'k', 'r'},
                        new char[]{'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain"}));

        System.out.println(findWords(new char[][]{
                        new char[]{'a', 'b'},
                        new char[]{'c', 'd'}},
                new String[]{"abcd", "dcba", "dcab", "abdc"}));

        System.out.println(findWords(new char[][]{
                        new char[]{'a'}},
                new String[]{"a"}));

        System.out.println(findWords(new char[][]{
                        new char[]{'a', 'a'}},
                new String[]{"aaa"}));

        System.out.println(findWords(new char[][]{
                        new char[]{'o', 'a', 'a', 'n'},
                        new char[]{'e', 't', 'a', 'e'},
                        new char[]{'i', 'h', 'k', 'r'},
                        new char[]{'i', 'f', 'l', 'v'}},
                new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));

    }


}
