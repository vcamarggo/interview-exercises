package com.interview.sde.icaro;

import java.util.*;

class Interview {
    private static char[][] board;

    public static void main(String[] args) {
        char startingChar = 'S';
        char targetChar = 'E';
        char toAvoidChar = '#';

        PairsInBoard pairStartEnd = populateBoard(startingChar, targetChar);
        try {
            int minSteps = breadthFirstSearch(pairStartEnd, board, toAvoidChar);
            assert minSteps == 4 : "Something went wrong";
        } catch (NoSuchElementException elementNotFoundException) {
            System.out.println("Element is impossible to be reached from the starting point");
        }
    }

    private static PairsInBoard populateBoard(char startingChar, char targetChar) {
        int startRow = 0;
        int startCol = 0;

        int targetRow = 0;
        int targetCol = 0;

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
        return new PairsInBoard(new RowColumnPair(startRow, startCol), new RowColumnPair(targetRow, targetCol));
    }

    private static int breadthFirstSearch(PairsInBoard pairStartEnd, char[][] board, char toAvoidChar) {

        int startRow = pairStartEnd.startingPoint.row;
        int startCol = pairStartEnd.startingPoint.column;

        Queue<Node> queue = new LinkedList<>();


        Node firstNode = new Node(board[startRow][startCol], 0, startRow, startCol);
        queue.add(firstNode);

        Set<Node> createdNodes = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int row = node.rowColumnPair.row;
            int column = node.rowColumnPair.column;

            if (node.rowColumnPair.equals(pairStartEnd.targetPoint)) {
                return node.depth;
            } else if (!createdNodes.contains(node)) {
                createdNodes.add(node);
                //checkTopLeft
                if ((row > 0 && column > 0) && board[row - 1][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column - 1], node.depth + 1, row - 1, column - 1));
                }

                //checkTopRight
                if ((row > 0 && column < board[0].length - 1) && board[row - 1][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column + 1], node.depth + 1, row - 1, column + 1));
                }

                //checkBottomRight
                if ((row < board.length - 1 && column < board[0].length - 1) && board[row + 1][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column + 1], node.depth + 1, row + 1, column + 1));
                }

                //checkBottomLeft
                if ((row < board.length - 1 && column > 0) && board[row + 1][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column - 1], node.depth + 1, row + 1, column - 1));
                }

                //checkLeft
                if (column > 0 && board[row][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row][column - 1], node.depth + 1, row, column - 1));
                }

                //checkRight
                if (column < board[0].length - 1 && board[row][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row][column + 1], node.depth + 1, row, column + 1));
                }

                //checkTop
                if (row > 0 && board[row - 1][column] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column], node.depth + 1, row - 1, column));
                }

                //checkBottom
                if (row < board.length - 1 && board[row + 1][column] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column], node.depth + 1, row + 1, column));
                }

            }
        }
        throw new NoSuchElementException();
    }

    static class Node {
        int depth;
        char elem;
        RowColumnPair rowColumnPair;

        Node(char elem, int depth, int i, int j) {
            this.depth = depth;
            this.elem = elem;
            this.rowColumnPair = new RowColumnPair(i, j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(rowColumnPair, node.rowColumnPair);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowColumnPair);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "depth=" + depth +
                    ", elem=" + elem +
                    ", rowColumnPair=" + rowColumnPair +
                    '}';
        }
    }

    private static class RowColumnPair {
        final int row;
        final int column;

        public RowColumnPair(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RowColumnPair rowColumnPair = (RowColumnPair) o;
            return row == rowColumnPair.row &&
                    column == rowColumnPair.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "RowColumnPair{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }

    private static class PairsInBoard {
        final RowColumnPair startingPoint;
        final RowColumnPair targetPoint;

        private PairsInBoard(RowColumnPair startingPoint, RowColumnPair targetPoint) {
            this.startingPoint = startingPoint;
            this.targetPoint = targetPoint;
        }
    }
}