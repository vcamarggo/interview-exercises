package com.interview.sde.algorithm.dynamicprogramming;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
//https://www.hackerrank.com/challenges/linkedin-practice-dynamic-programming-lcs/problem

public class LongestCommonSubsequence {
    private static final Scanner scanner = new Scanner(System.in);

    private static String lcsForStringChars(String s1, String s2) {
        String lcsForArray = longestCommonSubsequence(s1.chars().mapToObj(c -> (char) c).toArray(Character[]::new),
                s2.chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        return lcsForArray.replaceAll(" ", "");
    }

    // Complete the longestCommonSubsequence function below.
    static <T> String longestCommonSubsequence(T[] a1, T[] a2) {
        int[][] lcsCounter = new int[a1.length + 1][a2.length + 1];

        for (int s1Index = 1; s1Index < lcsCounter.length; s1Index++) {
            for (int s2Index = 1; s2Index < lcsCounter[0].length; s2Index++) {
                if (a1[s1Index - 1].equals(a2[s2Index - 1])) {
                    lcsCounter[s1Index][s2Index] = lcsCounter[s1Index - 1][s2Index - 1] + 1;
                } else {
                    lcsCounter[s1Index][s2Index] = Math.max(lcsCounter[s1Index - 1][s2Index], lcsCounter[s1Index][s2Index - 1]);
                }
            }
        }

        return getResult(a1, a2, lcsCounter);
    }

    private static <T> String getResult(T[] a1, T[] a2, int[][] lcsCounter) {
        int resultCounter = 0;
        StringBuilder resultString = new StringBuilder();

        int s1Index = lcsCounter.length - 1;
        int s2Index = lcsCounter[0].length - 1;
        while (lcsCounter[lcsCounter.length - 1][lcsCounter[0].length - 1] > resultCounter) {
            if (a1[s1Index - 1].equals(a2[s2Index - 1])) {
                resultCounter++;
                resultString.insert(0, a1[s1Index - 1] + " ");
                s1Index--;
                s2Index--;
            } else if (lcsCounter[s1Index - 1][s2Index] > lcsCounter[s1Index][s2Index - 1]) {
                s1Index--;
            } else {
                s2Index--;
            }
        }
        //returning the list of elements in string format separated by empty spaces
        return resultString.toString().trim();
    }

    public static void main(String[] args) {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        Integer[] a = new Integer[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        Integer[] b = new Integer[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        String string1 = "GTACCGTCA";
        String string2 = "CATCGA";

        String sentence1 = "1 2 3 4 1";
        String sentence2 = "3 4 1 2 1 3";
        System.out.println(lcsForStringChars(string1, string2));
        System.out.println(longestCommonSubsequence(sentence1.split(" "), sentence2.split(" ")));

        System.out.println(longestCommonSubsequence(a, b));
        scanner.close();
    }
}

