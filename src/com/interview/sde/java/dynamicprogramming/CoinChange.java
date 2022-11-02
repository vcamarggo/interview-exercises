package com.interview.sde.java.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/coin-change/problem
public class CoinChange {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        long[][] solvingMatrix = new long[c.size() + 1][n + 1];
        c.add(0, 0L);

        for (int row = 1; row < solvingMatrix.length; row++) {

            solvingMatrix[row][0] = 1;

            for (int column = 1; column < solvingMatrix[0].length; column++) {
                if (c.get(row) <= column) {
                    solvingMatrix[row][column] += solvingMatrix[row][(int) (column - c.get(row))];
                }
                solvingMatrix[row][column] += solvingMatrix[row - 1][column];
            }
        }
        return solvingMatrix[c.size() - 1][n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .sorted()
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);
        System.out.println(ways);

        bufferedReader.close();
    }
}

