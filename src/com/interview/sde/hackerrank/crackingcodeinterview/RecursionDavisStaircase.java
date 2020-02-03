package com.interview.sde.hackerrank.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
public class RecursionDavisStaircase {

    // Complete the stepPerms function below.
    static int stepPermsTopDown(int[] memo, int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] == 0) {
            memo[n] = stepPermsTopDown(memo, n - 3) + stepPermsTopDown(memo, n - 2) + stepPermsTopDown(memo, n - 1);
        }
        return memo[n];
    }

    static int stepPermsBottomUp(int n) {
        int[] memo = new int[37];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }

    static int stepPermsNonMemo(int n) {
        int n3 = 1;
        int n2 = 1;
        int n1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = n1 + n2 + n3;
            n3 = n2;
            n2 = n1;
            n1 = result;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main1(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] memo = new int[n + 1];
            int res = stepPermsNonMemo(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

