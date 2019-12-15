package com.interview.sde.mock.icaro.strategy;

import com.interview.sde.mock.icaro.elements.*;

import java.util.*;

public class AStarFromScratch {

    static char[][] board;

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

        PriorityQueue<NodeStar> openSet = new PriorityQueue<>();
        HashMap<RowColumnPair, NodeStar> createdNodes = new HashMap<>();

        NodeStar firstNode = new NodeStar(board[startRow][startCol], 0, startRow, startCol, euclideanDistance(pairStartEnd.getStartingPoint(), pairStartEnd.getTargetPoint()));

        openSet.add(firstNode);
        createdNodes.put(firstNode.getPoint(), firstNode);

        while (!openSet.isEmpty()) {
            NodeStar node = openSet.poll();

            int row = node.getPoint().getRow();
            int column = node.getPoint().getColumn();

            if (node.getPoint().equals(pairStartEnd.getTargetPoint())) {
                return node.getFScore();
            }

            createNeighbors(toAvoidChar, createdNodes, row, column);

            //checkTopLeft
            if ((row > 0 && column > 0)) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row - 1, column - 1);
            }

            //checkTopRight
            if ((row > 0 && column < board[0].length - 1)) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row - 1, column + 1);
            }

            //checkBottomRight
            if (row < board.length - 1 && column < board[0].length - 1) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row + 1, column + 1);
            }

            //checkBottomLeft
            if (row < board.length - 1 && column > 0) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row + 1, column - 1);
            }


            //checkLeft
            if (column > 0) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row, column - 1);
            }

            //checkRight
            if (column < board[0].length - 1) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row, column + 1);
            }

            //checkTop
            if (row > 0) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row - 1, column);
            }

            //checkBottom
            if (row < board.length - 1) {
                processNodeStar(pairStartEnd, openSet, createdNodes, node, row + 1, column);
            }
        }
        throw new NoSuchElementException();
    }

    private static void processNodeStar(PairsInBoard pairStartEnd, PriorityQueue<NodeStar> openSet, HashMap<RowColumnPair, NodeStar> createdNodes, NodeStar node, int row, int column) {
        RowColumnPair neighborPoint = new RowColumnPair(row, column);
        if (createdNodes.containsKey(neighborPoint)) {
            NodeStar neighborNode = createdNodes.get(neighborPoint);
            int tentativeGScore = node.getDepth() + 1;
            if (tentativeGScore < neighborNode.getDepth()) {
                neighborNode.setDepth(tentativeGScore);
                neighborNode.setFScore(neighborNode.getDepth() + euclideanDistance(neighborPoint, pairStartEnd.getTargetPoint()));
                openSet.add(neighborNode);
            }

        }
    }

    private static void createNeighbors(char toAvoidChar, HashMap<RowColumnPair, NodeStar> createdNodes, int row, int column) {
        //createTopLeft
        if ((row > 0 && column > 0)) {
            createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column - 1);
        }
        //checkTopRight
        if ((row > 0 && column < board[0].length - 1)) {
            createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column + 1);
        }

        //checkBottomRight
        if (row < board.length - 1 && column < board[0].length - 1) {
            createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column + 1);
        }

        //checkBottomLeft
        if (row < board.length - 1 && column > 0) {
            createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column - 1);
        }

        //checkLeft
        if (column > 0) {
            createSingleNeighbor(toAvoidChar, createdNodes, row, column - 1);
        }

        //checkRight
        if (column < board[0].length - 1) {
            createSingleNeighbor(toAvoidChar, createdNodes, row, column + 1);
        }

        //checkTop
        if (row > 0) {
            createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column);
        }

        //checkBottom
        if (row < board.length - 1) {
            createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column);
        }

    }

    private static void createSingleNeighbor(char toAvoidChar, HashMap<RowColumnPair, NodeStar> createdNodes, int localRow, int localColumn) {
        if (board[localRow][localColumn] != toAvoidChar) {
            RowColumnPair neighbor = new RowColumnPair(localRow, localColumn);
            if (!createdNodes.containsKey(neighbor)) {
                createdNodes.put(neighbor, new NodeStar(board[localRow][localColumn], Integer.MAX_VALUE, localRow, localColumn, Integer.MAX_VALUE));
            }
        }
    }

    private static int euclideanDistance(RowColumnPair startingPoint, RowColumnPair targetPoint) {
        int row = Math.abs(startingPoint.getRow() - targetPoint.getRow());
        int column = Math.abs(startingPoint.getColumn() - targetPoint.getColumn());
        return (int) Math.sqrt((row) * (row) + (column) * (column));
    }

}
