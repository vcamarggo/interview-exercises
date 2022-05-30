package com.interview.sde.algorithm.array;

import java.util.Arrays;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    static void setZeroes(int[][] matrix) {

        boolean rowZero = false;
        boolean columnZero = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    if (column == 0) {
                        columnZero = true;
                    }
                    if (row == 0) {
                        rowZero = true;
                    }
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        //Update all cells but first row and first column
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }

        //Update the first row to zero
        if (rowZero) {
            Arrays.fill(matrix[0], 0);
        }

        //Update the first column to zero
        if (columnZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{new int[]{1, 0, 3}});
        setZeroes(new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}});
        setZeroes(new int[][]{new int[]{0, 1, 1}, new int[]{1, 1, 1}, new int[]{1, 1, 1}});
    }
}
