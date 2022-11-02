package com.interview.sde.java.sorting;

//https://leetcode.com/problems/partition-array-according-to-given-pivot/
public class PartitionArrayPivot {
    public int[] pivotArray(int[] input, int pivot) {
        int[] solution = new int[input.length];

        // Initial index of smaller than pivot will always be zero
        int smallerPivotIndex = 0;
        // Initial index of the pivots
        int pivotIndex = 0;
        // Initial index of bigger than pivot based on array size
        int biggerPivotIndex = input.length;

        // Update the initial index of pivots and elements bigger than pivots
        for (int num : input) {
            if (pivot > num) {
                // first pivot index will be count of smaller than pivot
                // e.g. array is 0 based, so if there was 1 element smaller than pivot, the pivots should start at index 1
                pivotIndex++;
            }
            if (pivot < num) {
                // decreases the bigger pivot index (right-to-left) that will be used to fill the elements bigger than the index
                biggerPivotIndex--;
            }
        }

        // Write the output to new array
        for (int num : input) {
            if (pivot > num) {
                solution[smallerPivotIndex++] = num;
            } else if (pivot < num) {
                solution[biggerPivotIndex++] = num;
            } else {
                solution[pivotIndex++] = num;
            }
        }

        return solution;
    }
}
