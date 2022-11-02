package com.interview.sde.algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//https://leetcode.com/problems/n-queens/
public class NQueens {

    private boolean isSafe(final List<Integer> solverMatrix, final int indexToAdd) {
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
        System.out.println(new NQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();

        Stack<List<Integer>> toProcess = new Stack<>();
        toProcess.add(new ArrayList<>());

        while (!toProcess.isEmpty()) {
            List<Integer> current = toProcess.pop();
            if (current.size() == n) {
                //String builder to convert a number to ...Q., where the Q is the number position in the solution
                solution.add(current.stream().map(integer -> new StringBuilder(new String(new char[n]).replace("\0", ".")).replace(integer,integer+1, "Q").toString()).collect(Collectors.toList()));
            } else {
                for (int i = 0; i < n; i++) {
                    if(isSafe(current, i)){
                        List<Integer> possibleSolution = new ArrayList<>(current);
                        possibleSolution.add(i);
                        toProcess.push(possibleSolution);
                    }
                }
            }
        }


        return solution;
    }
}
