package com.interview.sde.hackerrank.algorithm.arrays;

//https://leetcode.com/problems/count-submatrices-with-all-ones/submissions/
public class SubMatrixWithOne {
    public int numSubmat(int[][] mat) {
        int numberRow = mat.length;
        int numberColumn = mat[0].length;

        for (int row = 0; row < numberRow ; row++) {
            for (int column = numberColumn - 2; column >= 0; column--) {
                if (mat[row][column] == 1) {
                    mat[row][column] = 1 + mat[row][column + 1];
                }
            }
        }

        int result = 0;

        for (int column = 0; column < numberColumn; column++) {
            for (int row = 0; row < numberRow; row++) {

                int current = mat[row][column];

                for (int tempRow = row; tempRow < numberRow; tempRow++) {
                    current = Math.min(current, mat[tempRow][column]);
                    result += current;
                }

            }
        }
        return result;
    }
}
