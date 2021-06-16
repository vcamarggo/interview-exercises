package com.interview.sde.algorithm.tree;

//https://leetcode.com/problems/word-search/
//Refer to TreeDictionaryMatrix.java
class TrieWordMatrix {

    boolean exist(char[][] board, String word) {
        return !TrieDictionaryMatrix.findWords(board, new String[]{word}).isEmpty();
    }

}
