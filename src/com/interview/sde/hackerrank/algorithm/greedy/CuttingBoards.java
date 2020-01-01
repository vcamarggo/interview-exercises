package com.interview.sde.hackerrank.algorithm.greedy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/board-cutting
public class CuttingBoards {

    //performance x maintainability
    //Not sure if I should prefer one or another
    static int yIndex, xIndex;
    static int xCounter = 1;
    static int yCounter = 1;
    static long[] cost_y;
    static long[] cost_x;

    // Complete the boardCutting function below.
    static int boardCutting() {
        Arrays.sort(cost_y);
        Arrays.sort(cost_x);

        yIndex = cost_y.length - 1;
        xIndex = cost_x.length - 1;

        BigInteger result = BigInteger.ZERO;

        while (yIndex >= 0 || xIndex >= 0) {
            if (yIndex < 0) {
                result = getFromX(result);
            } else if (xIndex < 0) {
                result = getFromY(result);
            } else {
                if (cost_y[yIndex] > cost_x[xIndex]) {
                    result = getFromY(result);
                } else if (cost_x[xIndex] > cost_y[yIndex]) {
                    result = getFromX(result);
                } else {
                    if (xCounter > yCounter) {
                        result = getFromY(result);
                    } else {
                        result = getFromX(result);
                    }
                }
            }
        }
        return result.mod(BigInteger.valueOf((long) Math.pow(10, 9) + 7)).intValue();
    }

    private static BigInteger getFromY(BigInteger result) {
        result = result.add(BigInteger.valueOf(cost_y[yIndex] * yCounter));
        yIndex--;
        xCounter++;
        return result;
    }

    private static BigInteger getFromX(BigInteger result) {
        result = result.add(BigInteger.valueOf(cost_x[xIndex] * xCounter));
        xIndex--;
        yCounter++;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            cost_y = new long[m - 1];

            String[] cost_yItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m - 1; i++) {
                long cost_yItem = Long.parseLong(cost_yItems[i]);
                cost_y[i] = cost_yItem;
            }

            cost_x = new long[n - 1];

            String[] cost_xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n - 1; i++) {
                long cost_xItem = Long.parseLong(cost_xItems[i]);
                cost_x[i] = cost_xItem;
            }

            int result = boardCutting();
            System.out.println(result);
        }


        scanner.close();
    }
}
