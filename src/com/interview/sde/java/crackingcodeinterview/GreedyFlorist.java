package com.interview.sde.java.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/greedy-florist/problem
public class GreedyFlorist {
    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int[] friends = new int[k];

        int minimumCost = 0;
        for (int i = 0; i < k; i++) {
            friends[i] += 1;
            minimumCost += c[c.length - 1 - i];
        }
        for (int i = c.length - 1 - k; i >= 0; i--) {
            int key = i % k;
            friends[key] += 1;
            minimumCost += c[i] * friends[key];

        }
        return minimumCost;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

