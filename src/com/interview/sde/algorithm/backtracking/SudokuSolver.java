package com.interview.sde.algorithm.backtracking;

import java.util.*;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    private final Map<Integer, Set<Character>> row = new HashMap<>();
    private final Map<Integer, Set<Character>> column = new HashMap<>();
    private final Map<Integer, Set<Character>> block = new HashMap<>();

    public static void main(String[] args) {
        new SudokuSolver().solveSudoku(new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
        new SudokuSolver().solveSudoku(new char[][]{
                new char[]{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                new char[]{'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                new char[]{'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                new char[]{'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                new char[]{'.', '.', '.', '2', '7', '5', '9', '.', '.'}});
    }

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int blockKey = (r / 3) * 3 + c / 3;
                    row.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c]);
                    column.computeIfAbsent(c, k -> new HashSet<>()).add(board[r][c]);
                    block.computeIfAbsent(blockKey, k -> new HashSet<>()).add(board[r][c]);
                }
            }
        }

        solveSudoku(board, 0);
        System.out.println(Arrays.deepToString(board));
    }

    boolean solveSudoku(char[][] board, int idx) {
        if (idx == 81) {
            return true;
        }
        int idxR = idx / 9;
        int idxC = idx % 9;
        int idxB = (idxR / 3) * 3 + idxC / 3;

        if (board[idxR][idxC] == '.') {

            for (int i = 1; i < 10; i++) {

                board[idxR][idxC] = (char) (i + 48);

                if (isValidSudoku(board, idxR, idxC, idxB)) {
                    row.computeIfAbsent(idxR, k -> new HashSet<>()).add(board[idxR][idxC]);
                    column.computeIfAbsent(idxC, k -> new HashSet<>()).add(board[idxR][idxC]);
                    block.computeIfAbsent(idxB, k -> new HashSet<>()).add(board[idxR][idxC]);
                    if (solveSudoku(board, idx + 1)) {
                        return true;
                    }
                    row.computeIfAbsent(idxR, k -> new HashSet<>()).remove(board[idxR][idxC]);
                    column.computeIfAbsent(idxC, k -> new HashSet<>()).remove(board[idxR][idxC]);
                    block.computeIfAbsent(idxB, k -> new HashSet<>()).remove(board[idxR][idxC]);
                }
                board[idxR][idxC] = '.';
            }
            return false;
        } else {
            return solveSudoku(board, idx + 1);
        }
    }

    boolean isValidSudoku(char[][] board, int r, int c, int b) {
        return (!row.containsKey(r) || !row.get(r).contains(board[r][c]))
                && (!column.containsKey(c) || !column.get(c).contains(board[r][c]))
                && (!block.containsKey(b) || !block.get(b).contains(board[r][c]));
    }
}
