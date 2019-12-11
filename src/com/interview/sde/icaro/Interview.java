package com.interview.sde.icaro;

import java.util.*;


class Interview {
    private static char[][] board;

    public static void main(String[] args) {
        RowColumnPair startingPoint = populateBoard('S');
        try {
            breadthFirstSearch(startingPoint.row, startingPoint.column, board, '#', 'E');
        } catch (NoSuchElementException elementNotFoundException) {
            System.out.println("Element is impossible to be reached from the starting point");
        }
    }

    private static RowColumnPair populateBoard(char startingChar) {
        int startRow = 0;
        int startCol = 0;

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
                    }
                    board[i][j] = charAtIJ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Should it exit gracefully?
            System.exit(1);
        }
        return new RowColumnPair(startRow, startCol);
    }

    private static void breadthFirstSearch(int startRow, int startCol, char[][] board, char charElementToAvoid, char targetChar) {
        //criar metodo
        Queue<Node> queue = new LinkedList<>();
        Node firstNode = new Node(board[startRow][startCol], 0, startRow, startCol);
        queue.add(firstNode);

        Set<Node> createdNodes = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int row = node.rowColumnPair.row;
            int column = node.rowColumnPair.column;

            if (node.elem == targetChar) {
                System.out.println(node.depth);
                return;
            } else if (!createdNodes.contains(node)) {
                createdNodes.add(node);
                //checkLeft
                if (column > 0 && board[row][column - 1] != charElementToAvoid) {
                    queue.add(new Node(board[row][column - 1], node.depth + 1, row, column - 1));
                }

                //checkRight
                if (column < board[0].length - 1 && board[row][column + 1] != charElementToAvoid) {
                    queue.add(new Node(board[row][column + 1], node.depth + 1, row, column + 1));
                }

                //checkTop
                if (row > 0 && board[row - 1][column] != charElementToAvoid) {
                    queue.add(new Node(board[row - 1][column], node.depth + 1, row - 1, column));
                }


                //checkBottom
                if (row < board.length - 1 && board[row + 1][column] != charElementToAvoid) {
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
    }
}