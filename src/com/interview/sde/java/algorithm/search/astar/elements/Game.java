package com.interview.sde.algorithm.search.astar.elements;

public class Game {
    private PairsInBoard pairsStartEnd;
    private char[][] board;

    public Game(PairsInBoard pairsStartEnd, char[][] board) {
        this.pairsStartEnd = pairsStartEnd;
        this.board = board;
    }

    public PairsInBoard getPairsStartEnd() {
        return pairsStartEnd;
    }

    public char[][] getBoard() {
        return board;
    }
}
