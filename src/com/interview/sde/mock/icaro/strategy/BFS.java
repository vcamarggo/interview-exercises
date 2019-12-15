package com.interview.sde.mock.icaro.strategy;

import com.interview.sde.mock.icaro.elements.Node;
import com.interview.sde.mock.icaro.elements.PairsInBoard;
import com.interview.sde.mock.icaro.elements.RowColumnPair;

import java.util.*;

class BFS {
    private static char[][] board;

    public static void main(String[] args) {
        char startingChar = 'S';
        char targetChar = 'E';
        char toAvoidChar = '#';

        PairsInBoard pairStartEnd = populateBoard(startingChar, targetChar);
        try {
            long start = System.currentTimeMillis();
            int minStepsDFS = breadthFirstSearch(pairStartEnd, toAvoidChar);
            System.out.println(minStepsDFS);
            System.out.println("Milliseconds DFS: " + (System.currentTimeMillis() - start));

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


    private static int breadthFirstSearch(PairsInBoard pairStartEnd, char toAvoidChar) {

        int startRow = pairStartEnd.getStartingPoint().getRow();
        int startCol = pairStartEnd.getStartingPoint().getColumn();

        Queue<Node> queue = new LinkedList<>();


        Node firstNode = new Node(board[startRow][startCol], 0, startRow, startCol);
        queue.add(firstNode);

        Set<Node> createdNodes = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int row = node.getPoint().getRow();
            int column = node.getPoint().getColumn();

            if (node.getPoint().equals(pairStartEnd.getTargetPoint())) {
                return node.getDepth();
            } else if (!createdNodes.contains(node)) {
                createdNodes.add(node);
                //checkTopLeft
                if ((row > 0 && column > 0) && board[row - 1][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column - 1], node.getDepth() + 1, row - 1, column - 1));
                }

                //checkTopRight
                if ((row > 0 && column < board[0].length - 1) && board[row - 1][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column + 1], node.getDepth() + 1, row - 1, column + 1));
                }

                //checkBottomRight
                if ((row < board.length - 1 && column < board[0].length - 1) && board[row + 1][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column + 1], node.getDepth() + 1, row + 1, column + 1));
                }

                //checkBottomLeft
                if ((row < board.length - 1 && column > 0) && board[row + 1][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column - 1], node.getDepth() + 1, row + 1, column - 1));
                }

                //checkLeft
                if (column > 0 && board[row][column - 1] != toAvoidChar) {
                    queue.add(new Node(board[row][column - 1], node.getDepth() + 1, row, column - 1));
                }

                //checkRight
                if (column < board[0].length - 1 && board[row][column + 1] != toAvoidChar) {
                    queue.add(new Node(board[row][column + 1], node.getDepth() + 1, row, column + 1));
                }

                //checkTop
                if (row > 0 && board[row - 1][column] != toAvoidChar) {
                    queue.add(new Node(board[row - 1][column], node.getDepth() + 1, row - 1, column));
                }

                //checkBottom
                if (row < board.length - 1 && board[row + 1][column] != toAvoidChar) {
                    queue.add(new Node(board[row + 1][column], node.getDepth() + 1, row + 1, column));
                }

            }
        }
        throw new NoSuchElementException();
    }

}