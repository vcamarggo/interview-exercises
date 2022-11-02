package com.interview.sde.java.search;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegion {
    public void solve(char[][] board) {

        Queue<Integer> borders = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                borders.add(i);
                borders.add(0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                borders.add(i);
                borders.add(board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                borders.add(0);
                borders.add(i);
            }
            if (board[board.length - 1][i] == 'O') {
                borders.add(board.length - 1);
                borders.add(i);
            }
        }

        while (!borders.isEmpty()) {
            int neighborRow = borders.poll();
            int neighborColumn = borders.poll();

            board[neighborRow][neighborColumn] = 'o';

            if (neighborRow - 1 >= 0 && board[neighborRow - 1][neighborColumn] == 'O') {
                borders.offer(neighborRow - 1);
                borders.offer(neighborColumn);
            }

            if (neighborRow + 1 < board.length && board[neighborRow + 1][neighborColumn] == 'O') {
                borders.offer(neighborRow + 1);
                borders.offer(neighborColumn);
            }

            if (neighborColumn - 1 >= 0 && board[neighborRow][neighborColumn - 1] == 'O') {
                borders.offer(neighborRow);
                borders.offer(neighborColumn - 1);
            }

            if (neighborColumn + 1 < board[0].length && board[neighborRow][neighborColumn + 1] == 'O') {
                borders.offer(neighborRow);
                borders.offer(neighborColumn + 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'o') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
//        new SurroundedRegion().solve(new char[][]{
//                new char[]{'X', 'X', 'X', 'X'},
//                new char[]{'X', 'O', 'O', 'X'},
//                new char[]{'X', 'X', 'O', 'X'},
//                new char[]{'X', 'O', 'X', 'X'}});


        new SurroundedRegion().solve(new char[][]{
                new char[]{'X', 'O', 'X', 'O', 'X', 'O'},
                new char[]{'O', 'X', 'O', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'O', 'X', 'O'},
                new char[]{'O', 'X', 'O', 'X', 'O', 'X'}});
    }
}
