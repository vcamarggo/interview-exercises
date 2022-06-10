package com.interview.sde.algorithm.array;

import java.util.Arrays;

//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
public class CountSquaresSubmatricesAllOne {

    static int countSquares(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (row > 0 && column > 0 && matrix[row][column] == 1) {
                    matrix[row][column] = Math.min(matrix[row - 1][column - 1], Math.min(matrix[row - 1][column], matrix[row][column - 1])) + 1;
                }
            }
        }
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{new int[]{0, 1, 1, 1}, new int[]{1, 1, 1, 1}, new int[]{0, 1, 1, 1}}));
    }
}
