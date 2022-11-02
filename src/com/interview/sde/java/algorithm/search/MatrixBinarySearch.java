package com.interview.sde.algorithm.search;

import java.util.Arrays;

//https://leetcode.com/problems/search-a-2d-matrix/
public class MatrixBinarySearch {
    static boolean searchMatrix(int[][] matrix, int target) {
        final int lastColumn = matrix[0].length - 1;
        for (int[] row : matrix) {
            if (row[lastColumn] >= target) {
                return Arrays.binarySearch(row, target) >= 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                        new int[]{1, 3, 5, 7},
                        new int[]{10, 11, 16, 20},
                        new int[]{23, 30, 34, 60},
                },
                32));
    }
}
