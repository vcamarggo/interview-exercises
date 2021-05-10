package com.interview.sde.hackerrank.algorithm.stack;

import java.util.LinkedList;

//https://leetcode.com/problems/n-queens-ii/
public class NQueens {
    static int totalNQueens(int n) {

        int result = 0;

        LinkedList<Integer> solution = new LinkedList<>();
        solution.add(-1);

        while (!solution.isEmpty()) {
            int currentRow = solution.pollLast() + 1;
            while (currentRow < n) {
                if (isSafe(solution, currentRow)) {
                    solution.offerLast(currentRow);
                    currentRow = 0;
                } else if (solution.size() == n) {
                    result++;
                    currentRow = solution.pollLast() + 1;
                } else {
                    currentRow++;
                }
            }
        }

        return result;
    }

    private static boolean isSafe(final LinkedList<Integer> solverMatrix, final int indexToAdd) {
        for (int i = 0; i < solverMatrix.size(); i++) {
            int deltaRow = Math.abs(solverMatrix.get(i) - indexToAdd);
            int deltaCol = Math.abs(i - solverMatrix.size());
            if (deltaRow == deltaCol) {
                return false;
            }
        }
        return solverMatrix.stream().noneMatch(integer -> integer == indexToAdd);
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }
}
