package com.interview.sde.mock.icaro.astar.strategy;

import com.interview.sde.mock.icaro.astar.elements.BoardReader;
import com.interview.sde.mock.icaro.astar.elements.Game;
import com.interview.sde.mock.icaro.astar.elements.Node;
import com.interview.sde.mock.icaro.astar.elements.PairsInBoard;

import java.util.*;

class DFS {
    private static char[][] board;

    public static void main(String[] args) {
        char startingChar = 'S';
        char targetChar = 'E';
        char toAvoidChar = '#';

        Game game = BoardReader.populateBoard(startingChar, targetChar);
        board = game.getBoard();
        try {
            long start = System.currentTimeMillis();
            int minStepsBFS = depthFirstSearch(game.getPairsStartEnd(), toAvoidChar);
            System.out.println(minStepsBFS);
            System.out.println("Milliseconds DFS: " + (System.currentTimeMillis() - start));

        } catch (NoSuchElementException elementNotFoundException) {
            System.out.println("Element is impossible to be reached from the starting point");
        }
    }

    private static int depthFirstSearch(PairsInBoard pairStartEnd, char toAvoidChar) {

        int startRow = pairStartEnd.getStartingPoint().getRow();
        int startCol = pairStartEnd.getStartingPoint().getColumn();

        Stack<Node> queue = new Stack<>();


        Node firstNode = new Node(board[startRow][startCol], 0, startRow, startCol);
        queue.add(firstNode);

        Set<Node> createdNodes = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.pop();

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