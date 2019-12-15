package com.interview.sde.mock.icaro.elements;

import java.util.Scanner;

public class BoardReader {
    public static Game populateBoard(char startingChar, char targetChar) {
        int startRow = 0;
        int startCol = 0;

        int targetRow = 0;
        int targetCol = 0;

        char[][] board = null;
        try (Scanner inputReader = new Scanner(System.in)) {
            int rows = inputReader.nextInt();
            int cols = inputReader.nextInt();
            board = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String line = inputReader.next();
                for (int j = 0; j < cols; j++) {
                    char charAtIJ = line.charAt(j);
                    if (charAtIJ == startingChar) {
                        startRow = i;
                        startCol = j;
                    } else if (charAtIJ == targetChar) {
                        targetRow = i;
                        targetCol = j;
                    }
                    board[i][j] = charAtIJ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Should it exit gracefully?
            System.exit(1);
        }
        return new Game(new PairsInBoard(new RowColumnPair(startRow, startCol), new RowColumnPair(targetRow, targetCol)), board);
    }
}
