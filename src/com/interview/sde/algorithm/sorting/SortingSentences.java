package com.interview.sde.algorithm.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/sorting-the-sentence/
/**
 * Note: the solution is based on MergeSort because I wanted to study it
 * for this small scope (digits 1 to 9 non-repeat),
 * creating a 9 positions array and putting them in the right position would suffice.
 * FYI: Radix sort: https://www.geeksforgeeks.org/radix-sort/
 **/
public class SortingSentences {


    static void mergeSort(String[] array, int start, int end) {
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(String[] array, int start, int mid, int end) {
        int countLeftElements = mid - start + 1;
        int countRightElements = end - mid;

        String[] leftElements = new String[countLeftElements];
        String[] rightElements = new String[countRightElements];

        System.arraycopy(array, start, leftElements, 0, countLeftElements);
        System.arraycopy(array, mid + 1, rightElements, 0, countRightElements);

        int copiedFromLeft = 0;
        int copiedFromRight = 0;

        while (copiedFromLeft + copiedFromRight < countRightElements + countLeftElements) {
            //if we dont have left elements or if we have right elements, and it is smaller than left, copy to output
            if (copiedFromLeft >= countLeftElements || copiedFromRight < countRightElements
                    //This is a test to order based on the last character of each string, which should be a number
                    && leftElements[copiedFromLeft].charAt(leftElements[copiedFromLeft].length() - 1) > rightElements[copiedFromRight].charAt(rightElements[copiedFromRight].length() - 1)) {
                array[start + copiedFromLeft + copiedFromRight] = rightElements[copiedFromRight++];
            } else {
                array[start + copiedFromLeft + copiedFromRight] = leftElements[copiedFromLeft++];
            }
        }

    }


    static String mergeSort(String input) {
        String[] arrayOfWords = input.split(" ");
        mergeSort(arrayOfWords, 0, arrayOfWords.length - 1);
        return Arrays.stream(arrayOfWords).map(str -> str.replaceAll("\\d", "")).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String input = "is2 sentence4 This1 a3";
        System.out.println(mergeSort(input));
    }
}
