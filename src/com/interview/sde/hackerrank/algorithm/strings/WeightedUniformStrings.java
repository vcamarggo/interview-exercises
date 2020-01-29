package com.interview.sde.hackerrank.algorithm.strings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/weighted-uniform-string/problem
public class WeightedUniformStrings {
    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];

        HashSet<Integer> keysCounted = new HashSet<>();

        char[] sArray = s.toCharArray();
        int[] score = new int[s.length()];

        keysCounted.add(sArray[0] - 96);
        score[0] = (sArray[0] - 96);

        for (int i = 1; i < sArray.length; i++) {
            if (sArray[i] == sArray[i - 1]) {
                score[i] = score[i - 1] + (sArray[i] - 96);
            } else {
                score[i] = (sArray[i] - 96);
            }
            keysCounted.add(score[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = keysCounted.contains(queries[i]) ? "Yes" : "No";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (String value : result) {
            System.out.println(value);
        }

        scanner.close();
    }
}
