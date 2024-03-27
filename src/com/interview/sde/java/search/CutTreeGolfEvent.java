package com.interview.sde.java.search;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/cut-off-trees-for-golf-event/
public class CutTreeGolfEvent {

    public int cutOffTree(List<List<Integer>> forest) {
        Queue<Integer> nextTree = new PriorityQueue<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.getFirst().size(); j++) {
                int elem = forest.get(i).get(j);
                if (elem > 1) {
                    nextTree.add(elem);
                }
            }
        }

        //No need to cut any tree
        if (nextTree.isEmpty())
            return 0;


        int sumOfDistances = 0;

        Queue<int[]> toProcess = new LinkedList<>();
        boolean[][] visited = new boolean[forest.size()][forest.getFirst().size()];

        toProcess.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!toProcess.isEmpty()) {
            int[] pair = toProcess.poll();
            int row = pair[0];
            int column = pair[1];
            int distance = pair[2];

            if (forest.get(row).get(column).equals(nextTree.peek())) {
                //discard element found
                nextTree.poll();
                //add its distance to the total sum
                sumOfDistances += distance;
                //clear the board state
                visited = new boolean[forest.size()][forest.getFirst().size()];
                toProcess.clear();
                //continue to process from current element to save computation
                visited[row][column] = true;
                distance = 0;
            }

            int topRow = row - 1;
            int rightColumn = column + 1;
            int bottomRow = row + 1;
            int leftColumn = column - 1;

            ///top
            if (topRow >= 0 && !visited[topRow][column] && forest.get(topRow).get(column) != 0) {
                toProcess.add(new int[]{topRow, column, distance + 1});
                visited[topRow][column] = true;
            }

            //right
            if (rightColumn <= forest.getFirst().size() - 1 && !visited[row][rightColumn] && forest.get(row).get(rightColumn) != 0) {
                toProcess.add(new int[]{row, rightColumn, distance + 1});
                visited[row][rightColumn] = true;
            }

            //bottom
            if (bottomRow <= forest.size() - 1 && !visited[bottomRow][column] && forest.get(bottomRow).get(column) != 0) {
                toProcess.add(new int[]{bottomRow, column, distance + 1});
                visited[bottomRow][column] = true;
            }

            //left
            if (leftColumn >= 0 && !visited[row][leftColumn] && forest.get(row).get(leftColumn) != 0) {
                toProcess.add(new int[]{row, leftColumn, distance + 1});
                visited[row][leftColumn] = true;
            }

        }

        //nextTree not empty means we were able to find reach of them,
        //if any is unreachable, we would stop adding nodes to process above, then, the above loop would exit having at least one nextTree to process
        return nextTree.isEmpty() ? sumOfDistances : -1;
    }
}
