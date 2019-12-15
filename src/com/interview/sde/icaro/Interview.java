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
            int minStepsDFS = breadthFirstSearch(pairStartEnd, toAvoidChar);
            assert minStepsDFS == 4 : "Something went wrong DFS";

            int minStepsAStar = aStar(pairStartEnd, toAvoidChar);
            assert minStepsAStar == 4 : "Something went wrong A*";

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

    private static int aStar(PairsInBoard pairStartEnd, char toAvoidChar) {
        int startRow = pairStartEnd.startingPoint.row;
        int startCol = pairStartEnd.startingPoint.column;

        TreeSet<NodeStar> openSet = new TreeSet<>();

        NodeStar firstNode = new NodeStar(board[startRow][startCol], 0, startRow, startCol, calculateManhattanDistance(pairStartEnd.startingPoint, pairStartEnd.targetPoint));

        openSet.add(firstNode);

        HashMap<RowColumnPair, NodeStar> createdNodes = new HashMap<>();

        while (!openSet.isEmpty()) {

            NodeStar node = openSet.first();
            openSet.remove(node);

            int row = node.point.row;
            int column = node.point.column;

            if (node.point.equals(pairStartEnd.targetPoint)) {
                System.out.println(node);
                return node.depth;
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

    private static void processNodeStar(PairsInBoard pairStartEnd, TreeSet<NodeStar> openSet, HashMap<RowColumnPair, NodeStar> createdNodes, NodeStar node, int row, int column) {
        RowColumnPair neighborPoint = new RowColumnPair(row, column);
        if (createdNodes.containsKey(neighborPoint)) {
            NodeStar neighborNode = createdNodes.get(neighborPoint);
            createdNodes.get(neighborPoint).depth = node.depth + 1;
            createdNodes.get(neighborPoint).fScore = createdNodes.get(neighborPoint).depth + calculateManhattanDistance(neighborPoint, pairStartEnd.targetPoint);
            openSet.add(neighborNode);
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

    private static int calculateManhattanDistance(RowColumnPair startingPoint, RowColumnPair targetPoint) {
        return Math.abs(startingPoint.row - targetPoint.row) + Math.abs(startingPoint.column - targetPoint.column);
    }

    private static int breadthFirstSearch(PairsInBoard pairStartEnd, char toAvoidChar) {

        int startRow = pairStartEnd.startingPoint.row;
        int startCol = pairStartEnd.startingPoint.column;

        Queue<Node> queue = new LinkedList<>();


        Node firstNode = new Node(board[startRow][startCol], 0, startRow, startCol);
        queue.add(firstNode);

        Set<Node> createdNodes = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            int row = node.point.row;
            int column = node.point.column;

            if (node.point.equals(pairStartEnd.targetPoint)) {
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

    static class NodeStar extends Node implements Comparable<NodeStar> {

        int fScore;

        NodeStar(char elem, int gScore, int row, int column, int fScore) {
            super(elem, gScore, row, column);
            this.fScore = fScore;
        }

        @Override
        public int compareTo(NodeStar o) {
            return Integer.compare(this.fScore, o.fScore);
        }

        @Override
        public String toString() {
            return "NodeStar{" +
                    "gScore=" + depth +
                    ", fScore=" + fScore +
                    ", elem=" + elem +
                    ", rowColumnPair=" + point +
                    '}';
        }
    }

    static class Node {
        int depth;
        char elem;
        RowColumnPair point;

        Node(char elem, int depth, int row, int column) {
            this.depth = depth;
            this.elem = elem;
            this.point = new RowColumnPair(row, column);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(point, node.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "depth=" + depth +
                    ", elem=" + elem +
                    ", rowColumnPair=" + point +
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