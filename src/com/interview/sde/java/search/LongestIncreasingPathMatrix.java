package com.interview.sde.java.search;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix
public class LongestIncreasingPathMatrix {


    public static int longestIncreasingPath(int[][] board) {

        final int ROWS = board.length;
        final int COLUMNS = board[0].length;

        int[][] memo = new int[ROWS][COLUMNS];

        int solutionSize = 0;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                boolean[][] visited = new boolean[ROWS][COLUMNS];

                solutionSize = Math.max(solutionSize, searchMaxPath(memo, board, row, column, visited, board[row][column], 1));
            }
        }

        return solutionSize;
    }

    private static int searchMaxPath(int[][] memo, int[][] board, int row, int column, boolean[][] visited, int currentNumber, int solutionSize) {
        if (memo[row][column] == 0) {
            int maxSize = solutionSize;

            int topRow = row - 1;
            int rightColumn = column + 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;

            visited[row][column] = true;
            //top
            if (topRow >= 0 && !visited[topRow][column] && board[topRow][column] > currentNumber) {
                maxSize = Math.max(maxSize, searchMaxPath(memo, board, topRow, column, visited, board[topRow][column], solutionSize + 1));
            }

            //right
            if (rightColumn <= board[0].length - 1 && !visited[row][rightColumn] && board[row][rightColumn] > currentNumber) {
                maxSize = Math.max(maxSize, searchMaxPath(memo, board, row, rightColumn, visited, board[row][rightColumn], solutionSize + 1));
            }

            //bottom
            if (bottomRow <= board.length - 1 && !visited[bottomRow][column] && board[bottomRow][column] > currentNumber) {
                maxSize = Math.max(maxSize, searchMaxPath(memo, board, bottomRow, column, visited, board[bottomRow][column], solutionSize + 1));
            }

            //left
            if (leftColumn >= 0 && !visited[row][leftColumn] && board[row][leftColumn] > currentNumber) {
                maxSize = Math.max(maxSize, searchMaxPath(memo, board, row, leftColumn, visited, board[row][leftColumn], solutionSize + 1));
            }

            visited[row][column] = false;

            memo[row][column] = maxSize - solutionSize;
            return maxSize;
        }
        return solutionSize + memo[row][column];
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{
                new int[]{9, 9, 4},
                new int[]{6, 6, 8},
                new int[]{2, 1, 1}}));

        System.out.println(longestIncreasingPath(new int[][]{
                new int[]{3, 4, 5},
                new int[]{3, 2, 6},
                new int[]{2, 2, 1}}));

        System.out.println(longestIncreasingPath(new int[][]{
                new int[]{1}}));

    }


}
