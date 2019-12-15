package com.interview.sde.mock.icaro.strategy;

import com.interview.sde.mock.icaro.elements.*;

import java.util.*;

class AStarBasedOnAEstrela {
    private static char[][] board;

    public static void main(String[] args) {
        char startingChar = 'S';
        char targetChar = 'E';
        char toAvoidChar = '#';

        Game game = BoardReader.populateBoard(startingChar, targetChar);
        board = game.getBoard();

        try {
            long start = System.currentTimeMillis();
            int minStepsAStar = aStar(game.getPairsStartEnd(), toAvoidChar);
            System.out.println(minStepsAStar);
            System.out.println("Milliseconds A*: " + (System.currentTimeMillis() - start));

        } catch (NoSuchElementException elementNotFoundException) {
            System.out.println("Element is impossible to be reached from the starting point");
        }
    }

    private static int aStar(PairsInBoard pairStartEnd, char toAvoidChar) {
        int startRow = pairStartEnd.getStartingPoint().getRow();
        int startCol = pairStartEnd.getStartingPoint().getColumn();

        TreeSet<NodeStar> openNodes = new TreeSet<>();
        HashMap<RowColumnPair, NodeStar> closedNodes = new HashMap<>();

        NodeStar firstNode = new NodeStar(board[startRow][startCol], 0, startRow, startCol);
        firstNode.setGScore(euclideanDistance(pairStartEnd.getStartingPoint(), pairStartEnd.getTargetPoint()));

        openNodes.add(firstNode);

        ArrayList<NodeStar> neighbors;

        while (!openNodes.isEmpty()) {

            NodeStar node = openNodes.first();
            openNodes.remove(node);

            if (node.getPoint().equals(pairStartEnd.getTargetPoint())) {
                return node.getFScore();
            }

            int row = node.getPoint().getRow();
            int column = node.getPoint().getColumn();

            closedNodes.put(node.getPoint(), node);

            neighbors = createNeighbors(toAvoidChar, row, column, node.getDepth());

            while (!neighbors.isEmpty()) {
                NodeStar neighbor = neighbors.get(0);
                neighbors.remove(neighbor);

                NodeStar open = openNodes.lower(neighbor);
                NodeStar closed = closedNodes.get(neighbor.getPoint());

                if (closed != null) {
                    if (neighbor.getDepth() < closed.getDepth()) {
                        closedNodes.remove(closed.getPoint());
                        neighbor.setGScore(euclideanDistance(neighbor.getPoint(), pairStartEnd.getTargetPoint()));
                        neighbor.setFScore(neighbor.getDepth() + neighbor.getGScore());
                        openNodes.add(neighbor);
                    }
                } else if (open != null) {
                    if (neighbor.getDepth() < open.getDepth()) {
                        openNodes.remove(open);
                        neighbor.setGScore(euclideanDistance(neighbor.getPoint(), pairStartEnd.getTargetPoint()));
                        neighbor.setFScore(neighbor.getDepth() + neighbor.getGScore());
                        openNodes.add(neighbor);
                    }
                } else {
                    neighbor.setGScore(euclideanDistance(neighbor.getPoint(), pairStartEnd.getTargetPoint()));
                    neighbor.setFScore(neighbor.getDepth() + neighbor.getGScore());
                    openNodes.add(neighbor);
                }
            }


        }
        throw new NoSuchElementException();
    }

    private static ArrayList<NodeStar> createNeighbors(char toAvoidChar, int row, int column, int parentDepth) {
        ArrayList<NodeStar> neighbors = new ArrayList<>();
        //createTopLeft
        if ((row > 0 && column > 0)) {
            createSingleNeighbor(toAvoidChar, row - 1, column - 1, parentDepth).ifPresent(neighbors::add);
        }
        //checkTopRight
        if ((row > 0 && column < board[0].length - 1)) {
            createSingleNeighbor(toAvoidChar, row - 1, column + 1, parentDepth).ifPresent(neighbors::add);
        }

        //checkBottomRight
        if (row < board.length - 1 && column < board[0].length - 1) {
            createSingleNeighbor(toAvoidChar, row + 1, column + 1, parentDepth).ifPresent(neighbors::add);
        }

        //checkBottomLeft
        if (row < board.length - 1 && column > 0) {
            createSingleNeighbor(toAvoidChar, row + 1, column - 1, parentDepth).ifPresent(neighbors::add);
        }

        //checkLeft
        if (column > 0) {
            createSingleNeighbor(toAvoidChar, row, column - 1, parentDepth).ifPresent(neighbors::add);
        }

        //checkRight
        if (column < board[0].length - 1) {
            createSingleNeighbor(toAvoidChar, row, column + 1, parentDepth).ifPresent(neighbors::add);
        }

        //checkTop
        if (row > 0) {
            createSingleNeighbor(toAvoidChar, row - 1, column, parentDepth).ifPresent(neighbors::add);
        }

        //checkBottom
        if (row < board.length - 1) {
            createSingleNeighbor(toAvoidChar, row + 1, column, parentDepth).ifPresent(neighbors::add);
        }
        return neighbors;
    }

    private static Optional<NodeStar> createSingleNeighbor(char toAvoidChar, int localRow, int localColumn, int previousDepth) {
        NodeStar node = null;
        if (board[localRow][localColumn] != toAvoidChar) {
            node = new NodeStar(board[localRow][localColumn], previousDepth + 1, localRow, localColumn);
        }
        return Optional.ofNullable(node);
    }

    private static int euclideanDistance(RowColumnPair startingPoint, RowColumnPair targetPoint) {
        int row = Math.abs(startingPoint.getRow() - targetPoint.getRow());
        int column = Math.abs(startingPoint.getColumn() - targetPoint.getColumn());
        return (int) Math.sqrt((row) * (row) + (column) * (column));
    }


}