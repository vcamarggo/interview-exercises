package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    final static int ALIVE = 1;
    final static int DEAD = 0;
    final static int WILL_DIE = -1;
    final static int WILL_LIVE = -2;

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveNeighbors = getAliveNeighborsCount(board, i, j);
                if (board[i][j] == DEAD) {
                    if (aliveNeighbors == 3) {
                        board[i][j] = WILL_LIVE;
                    }
                }
                if (board[i][j] == ALIVE) {
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        board[i][j] = WILL_DIE;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == WILL_DIE) {
                    board[i][j] = DEAD;
                }
                if (board[i][j] == WILL_LIVE) {
                    board[i][j] = ALIVE;
                }
            }
        }

    }

    private int getAliveNeighborsCount(int[][] board, int row, int column) {
        int aliveNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (i != row || j != column) && (board[i][j] == ALIVE || board[i][j] == WILL_DIE)) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }
}
