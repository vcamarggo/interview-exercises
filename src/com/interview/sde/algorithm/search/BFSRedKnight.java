package com.interview.sde.algorithm.search;


import java.util.*;

//https://www.hackerrank.com/challenges/candies/problem
class BFSRedKnight {

    public static class PairsInBoard {
        private final RowColumnPair startingPoint;
        private final RowColumnPair targetPoint;

        public PairsInBoard(RowColumnPair startingPoint, RowColumnPair targetPoint) {
            this.startingPoint = startingPoint;
            this.targetPoint = targetPoint;
        }

        public RowColumnPair getStartingPoint() {
            return startingPoint;
        }

        public RowColumnPair getTargetPoint() {
            return targetPoint;
        }
    }

    private enum MovementType {
        UL, UR, R, LR, LL, L
    }

    static class BFSNode extends Node {

        private boolean isVisited;

        public BFSNode(int row, int column, String movementType, int depth) {
            super(row, column, movementType, depth);
            isVisited = false;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited() {
            isVisited = true;
        }
    }

    static class Node {
        private RowColumnPair point;
        private String movementType;
        private int depth;

        public Node(int row, int column, String movementType, int depth) {
            this.point = new RowColumnPair(row, column);
            this.movementType = movementType;
            this.depth = depth;
        }

        public RowColumnPair getPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return depth == node.depth &&
                    Objects.equals(point, node.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, depth);
        }

        public int getDepth() {
            return depth;
        }

        public String getMovementType() {
            return movementType;
        }
    }

    static public class RowColumnPair {
        private final int row;
        private final int column;

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

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] i_startJ_start = scanner.nextLine().split(" ");

        int i_start = Integer.parseInt(i_startJ_start[0]);

        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        PairsInBoard pairsInBoard = new PairsInBoard(new RowColumnPair(i_start, j_start), new RowColumnPair(i_end, j_end));
        if (isReachable(Math.abs(i_start - i_end), Math.abs(j_start - j_end))) {
            Node solution = breadthFirstSearch(n, pairsInBoard);
            if (solution == null) {
                System.out.println("Impossible");
            } else {
                System.out.println(solution.getDepth());
                System.out.println(solution.getMovementType().substring(1));
            }
        } else {
            System.out.println("Impossible");
        }

        scanner.close();
    }

    static boolean isReachable(int diffI, int diffJ) {
        if (diffI % 2 == 1) return false;
        else if (diffI % 4 == 0) return !(diffJ % 2 == 1);
        else return diffJ % 2 == 1;
    }

    private static Node breadthFirstSearch(int boardSize, PairsInBoard pairStartEnd) {

        int startRow = pairStartEnd.getStartingPoint().getRow();
        int startCol = pairStartEnd.getStartingPoint().getColumn();

        Queue<BFSNode> queue = new LinkedList<>();

        BFSNode firstNode = new BFSNode(startRow, startCol, "", 0);
        queue.add(firstNode);

        while (!queue.isEmpty()) {

            BFSNode node = queue.poll();

            int row = node.getPoint().getRow();
            int column = node.getPoint().getColumn();

            if (node.getPoint().equals(pairStartEnd.getTargetPoint())) {
                return node;
            } else if (!node.isVisited()) {
                node.setVisited();
                //checkUL
                int ulRow = row - 2;
                int ulColumn = column - 1;
                if (ulRow >= 0 && ulColumn >= 1) {
                    queue.add(new BFSNode(ulRow, ulColumn, node.getMovementType() + " " + MovementType.UL.toString(), node.getDepth() + 1));
                }

                //checkUR
                int urRow = row - 2;
                int urColumn = column + 1;
                if (urRow >= 0 && urColumn < boardSize) {
                    queue.add(new BFSNode(urRow, urColumn, node.getMovementType() + " " + MovementType.UR.toString(), node.getDepth() + 1));
                }

                //checkR
                int rColumn = column + 2;
                if (rColumn < boardSize) {
                    queue.add(new BFSNode(row, rColumn, node.getMovementType() + " " + MovementType.R.toString(), node.getDepth() + 1));
                }

                //checkLR
                int lrRow = row + 2;
                int lrColumn = column + 1;
                if (lrRow < boardSize && lrColumn < boardSize) {
                    queue.add(new BFSNode(lrRow, lrColumn, node.getMovementType() + " " + MovementType.LR.toString(), node.getDepth() + 1));
                }

                //checkLL
                int llRow = row + 2;
                int llColumn = column - 1;
                if (llRow < boardSize && llColumn >= 0) {
                    queue.add(new BFSNode(llRow, llColumn, node.getMovementType() + " " + MovementType.LL.toString(), node.getDepth() + 1));
                }

                //checkL
                int lColumn = column - 2;
                if (lColumn >= 0) {
                    queue.add(new BFSNode(row, lColumn, node.getMovementType() + " " + MovementType.L.toString(), node.getDepth() + 1));
                }
            }
        }
        return null;
    }

}
