package com.interview.sde.hackerrank.algorithm.greedy;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/luck-balance/problem
public class LuckBalance {

    static void sortLuck(int[][] contests) {
        //arguments to this method represent the arrays to be sorted
        Arrays.sort(contests, (o1, o2) -> {
            //get the item ids which are at index 0 of the array
            Integer itemIdOne = o2[0];
            Integer itemIdTwo = o1[0];
            return itemIdOne.compareTo(itemIdTwo);
        });
    }

    static void sortImportance(int[][] contests) {
        Arrays.sort(contests, (o1, o2) -> {
            Integer quantityOne = o2[1];
            Integer quantityTwo = o1[1];
            // reverse sort on quantity
            return quantityOne.compareTo(quantityTwo);
        });
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        sortLuck(contests);
        sortImportance(contests);
        int remaining = k;
        int score = 0;

        for (int[] contest : contests) {
            if (contest[1] == 0) {
                score += contest[0];
            } else if (remaining > 0) {
                score += contest[0];
                remaining--;
            } else {
                score -= contest[0];
            }
        }

        return score;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

