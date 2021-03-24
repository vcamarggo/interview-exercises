package com.interview.sde.hackerrank.algorithm.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-kth-largest-xor-coordinate-value
public class KthLargestMatrixXOR {

    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{new int[]{5, 2}, new int[]{1, 6}}, 1));
    }

    public static int kthLargestValue(int[][] matrix, int k) {

        //Wasting memory here, keeping only K elements would suffice
        PriorityQueue<Integer> sorted = new PriorityQueue<>(matrix.length * matrix[0].length, Comparator.reverseOrder());

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 1; column < matrix[0].length; column++) {
                matrix[row][column] = matrix[row][column - 1] ^ matrix[row][column];
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = matrix[row - 1][column] ^ matrix[row][column];
                sorted.add(matrix[row][column]);
            }
        }

        //For clarity, I could have done row/column add, however I preferred to do separately to make it faster
        for (int column = 0; column < matrix[0].length; column++) {
            sorted.add(matrix[0][column]);
        }

        //This part cant be improved somehow
        int result = -1;
        for (int i = 0; i < k && !sorted.isEmpty(); i++) {
            result = sorted.poll();
        }
        return result;

    }
}
