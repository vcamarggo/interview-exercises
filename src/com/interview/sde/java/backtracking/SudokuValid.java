package com.interview.sde.java.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class SudokuValid {
    public static void main(String[] args) {
        System.out.println(new SudokuValid().isValidSudoku(new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }

    boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> column = new HashMap<>();
        Map<Integer, Set<Character>> block = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int blockKey = (r / 3) * 3 + c / 3;
                    if (row.containsKey(r) && row.get(r).contains(board[r][c])
                            || column.containsKey(c) && column.get(c).contains(board[r][c])
                            || block.containsKey(blockKey) && block.get(blockKey).contains(board[r][c])) {
                        return false;
                    }
                    row.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c]);
                    column.computeIfAbsent(c, k -> new HashSet<>()).add(board[r][c]);
                    block.computeIfAbsent(blockKey, k -> new HashSet<>()).add(board[r][c]);
                }
            }
        }
        return true;
    }
}
