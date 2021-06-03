package com.interview.sde.algorithm.search.astar.strategy;

import com.interview.sde.algorithm.search.astar.elements.*;

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
            System.out.println("Milliseconds A* - Scratch: " + (System.currentTimeMillis() - start));

        } catch (NoSuchElementException elementNotFoundException) {
            System.out.println("Element is impossible to be reached from the starting point");
        }
    }

    private static int aStar(PairsInBoard pairStartEnd, char toAvoidChar) {
        int startRow = pairStartEnd.getStartingPoint().getRow();
        int startCol = pairStartEnd.getStartingPoint().getColumn();

        //Priority Queue to get the smallest element in time O(1)
        PriorityQueue<NodeStar> shortestDistanceQueue = new PriorityQueue<>();

        //HashMap to make faster to find a createdNode via its Point (RowColumn)
        HashMap<RowColumnPair, NodeStar> createdNodes = new HashMap<>();

        NodeStar firstNode = new NodeStar(board[startRow][startCol], 0, startRow, startCol, euclideanDistance(pairStartEnd.getStartingPoint(), pairStartEnd.getTargetPoint()));

        shortestDistanceQueue.add(firstNode);
        createdNodes.put(firstNode.getPoint(), firstNode);

        while (!shortestDistanceQueue.isEmpty()) {
            NodeStar node = shortestDistanceQueue.poll();

            if (node.getPoint().equals(pairStartEnd.getTargetPoint())) {
                return node.getFScore();
            }
            ArrayList<NodeStar> neighbors;

            //Create neighbors
            neighbors = createNeighbors(toAvoidChar, createdNodes, node.getPoint().getRow(), node.getPoint().getColumn());

            while (!neighbors.isEmpty()) {
                NodeStar neighbor = neighbors.get(0);
                neighbors.remove(neighbor);
                //evaluate a distance form a given node from the neighbors
                processNodeStar(pairStartEnd, shortestDistanceQueue, createdNodes, node, neighbor);
            }

        }
        throw new NoSuchElementException();
    }

    private static void processNodeStar(PairsInBoard pairStartEnd, PriorityQueue<NodeStar> openSet, HashMap<RowColumnPair, NodeStar> createdNodes, NodeStar node, NodeStar neighbor) {
        int tentativeGScore = node.getDepth() + 1;
        if (tentativeGScore < neighbor.getDepth()) {
            neighbor.setDepth(tentativeGScore);
            neighbor.setFScore(neighbor.getDepth() + euclideanDistance(neighbor.getPoint(), pairStartEnd.getTargetPoint()));
            openSet.add(neighbor);
        }
    }

    private static ArrayList<NodeStar> createNeighbors(char toAvoidChar, HashMap<RowColumnPair, NodeStar> createdNodes, int row, int column) {
        ArrayList<NodeStar> neighbors = new ArrayList<>();

        // Add each element around the point P if they aren't null

        //createTopLeft
        createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column - 1).ifPresent(neighbors::add);
        //checkTopRight
        createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column + 1).ifPresent(neighbors::add);
        //checkBottomRight
        createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column + 1).ifPresent(neighbors::add);
        //checkBottomLeft
        createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column - 1).ifPresent(neighbors::add);
        //checkLeft
        createSingleNeighbor(toAvoidChar, createdNodes, row, column - 1).ifPresent(neighbors::add);
        //checkRight
        createSingleNeighbor(toAvoidChar, createdNodes, row, column + 1).ifPresent(neighbors::add);
        //checkTop
        createSingleNeighbor(toAvoidChar, createdNodes, row - 1, column).ifPresent(neighbors::add);
        //checkBottom
        createSingleNeighbor(toAvoidChar, createdNodes, row + 1, column).ifPresent(neighbors::add);

        return neighbors;
    }


    //Throws an neighbor if it hasn't been created before, otherwise, throw a null element in a Optional
    private static Optional<NodeStar> createSingleNeighbor(char toAvoidChar, HashMap<RowColumnPair, NodeStar> createdNodes, int localRow, int localColumn) {
        NodeStar neighbor = null;
        try {
            // don't add the neighbor if is the element to avoid
            if (board[localRow][localColumn] != toAvoidChar) {
                RowColumnPair neighborPoint = new RowColumnPair(localRow, localColumn);
                if (!createdNodes.containsKey(neighborPoint)) {
                    neighbor = new NodeStar(board[localRow][localColumn], Integer.MAX_VALUE, localRow, localColumn, Integer.MAX_VALUE);
                    createdNodes.put(neighborPoint, neighbor);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return Optional.ofNullable(neighbor);
    }

    private static int euclideanDistance(RowColumnPair startingPoint, RowColumnPair targetPoint) {
        int row = Math.abs(startingPoint.getRow() - targetPoint.getRow());
        int column = Math.abs(startingPoint.getColumn() - targetPoint.getColumn());
        return (int) Math.sqrt((row) * (row) + (column) * (column));
    }

}
