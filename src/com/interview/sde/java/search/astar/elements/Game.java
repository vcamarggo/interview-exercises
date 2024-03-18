package com.interview.sde.java.search.astar.elements;

public class Game {
    private final PairsInBoard pairsStartEnd;
    private final char[][] board;

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
