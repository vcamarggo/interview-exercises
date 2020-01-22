package com.interview.sde.mock.icaro.astar.elements;

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
