package com.interview.sde.hackerrank.algorithm.search;

import java.util.Arrays;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class MatrixBinarySearch {
    static boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        for (int[] ints : matrix) {
            column = Arrays.binarySearch(ints, 0, column, target);

            if (column >= 0) {
                return true;
            }
            column = Math.abs(++column);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                        new int[]{1, 4, 7, 11, 15},
                        new int[]{2, 5, 8, 12, 19},
                        new int[]{3, 6, 9, 16, 22},
                        new int[]{10, 13, 14, 17, 24},
                        new int[]{18, 21, 23, 26, 30}},
                5));
        System.out.println(searchMatrix(new int[][]{
                        new int[]{-1, 3}},
                3));
    }
}
