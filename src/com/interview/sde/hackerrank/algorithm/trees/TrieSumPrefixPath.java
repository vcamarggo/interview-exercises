package com.interview.sde.hackerrank.algorithm.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/map-sum-pairs/
public class TrieSumPrefixPath {
    static class MapSum {

        TrieNode root;

        static class TrieNode {
            public int val;
            boolean isWord;
            Map<Character, TrieNode> children;

            TrieNode(boolean isWord, int val) {
                this.isWord = isWord;
                this.val = val;
                children = new HashMap<>();
            }
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

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode(false, 0);
        }

        public void insert(String key, int val) {
            TrieNode current = root;
            for (char data : key.toCharArray()) {
                if (!current.children.containsKey(data)) {
                    current.children.put(data, new TrieNode(false, 0));
                }
                current = current.children.get(data);
            }
            current.isWord = true;
            current.val = val;
        }

        public int sum(String prefix) {
            int sum = 0;
            TrieNode prefixRoot = searchNode(prefix);
            if (prefixRoot == null) {
                return 0;
            }

            //BFS to obtain sum of all leaf nodes
            Queue<TrieNode> toProcess = new LinkedList<>();
            toProcess.add(prefixRoot);
            while (!toProcess.isEmpty()) {
                TrieNode current = toProcess.poll();
                if (current.isWord) {
                    sum += current.val;
                }
                toProcess.addAll(current.children.values());
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }

}
