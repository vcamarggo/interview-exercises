package com.interview.sde.java.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class TrieMaximumXorPair {

    TrieNode root = new TrieNode(0);

    static class TrieNode {
        public int val;
        Map<Character, TrieNode> children;

        TrieNode(int val) {
            this.val = val;
            children = new HashMap<>();
        }
    }

    private int searchNode(int n) {
        int temp = 0;
        TrieNode curr = root;
        String key = integerToBinaryStringPad32(n);
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '0') {
                if (curr.children.containsKey('1')) {
                    temp += (int) Math.pow(2, key.length() - 1 - i);
                    curr = curr.children.get('1');
                } else {
                    curr = curr.children.get('0');
                }
            } else {
                if (curr.children.containsKey('0')) {
                    temp += (int) Math.pow(2, key.length() - 1 - i);
                    curr = curr.children.get('0');
                } else {
                    curr = curr.children.get('1');
                }
            }
        }
        return temp;
    }

    private String integerToBinaryStringPad32(int n) {
        return String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    public void insert(int val) {
        String key = integerToBinaryStringPad32(val);
        TrieNode current = root;
        for (char data : key.toCharArray()) {
            if (!current.children.containsKey(data)) {
                current.children.put(data, new TrieNode(0));
            }
            current = current.children.get(data);
        }
        current.val = val;
    }


    public int findMaximumXOR(int[] nums) {

        //Faster 33% faster than the used return
//        if (nums.length <= 1) {
//            return 0;
//        }
//        int diffMax = 0;
//
//        for (Integer num : nums) {
//            insert(num);
//        }
//        for (Integer num : nums) {
//            int diff = searchNode(num);
//
//            diffMax = Math.max(diffMax, diff);
//        }
//
//        return diffMax;
        return Arrays.stream(nums).peek(this::insert).map(this::searchNode).max().getAsInt();
    }
}
