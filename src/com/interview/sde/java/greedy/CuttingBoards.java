package com.interview.sde.java.greedy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/board-cutting
public class CuttingBoards {

    //performance x maintainability
    //Not sure if I should prefer one or another
    static int horizontalIndex, verticalIndex;
    static int verticalCutsMade;
    static int horizontalCutsMade;
    static long[] horizontalCutsCost;
    static long[] verticalCutsCost;

    // Complete the boardCutting function below.
    static int boardCutting() {
        Arrays.sort(horizontalCutsCost);
        Arrays.sort(verticalCutsCost);

        verticalCutsMade = 1;
        horizontalCutsMade = 1;
        horizontalIndex = horizontalCutsCost.length - 1;
        verticalIndex = verticalCutsCost.length - 1;

        BigInteger result = BigInteger.ZERO;

        while (horizontalIndex >= 0 || verticalIndex >= 0) {
            if (verticalIndex < 0 || (horizontalIndex >= 0 && horizontalCutsCost[horizontalIndex] > verticalCutsCost[verticalIndex])) {
                result = getFromY(result);
            } else if (horizontalIndex < 0 || verticalCutsCost[verticalIndex] > horizontalCutsCost[horizontalIndex]) {
                result = getFromX(result);
            } else {
                //costs are equal, choose the cut with less boards to cross
                if (verticalCutsMade > horizontalCutsMade) {
                    result = getFromY(result);
                } else {
                    result = getFromX(result);
                }
            }
        }
        return result.mod(BigInteger.valueOf((long) Math.pow(10, 9) + 7)).intValue();
    }

    private static BigInteger getFromY(BigInteger result) {
        result = result.add(BigInteger.valueOf(horizontalCutsCost[horizontalIndex] * horizontalCutsMade));
        horizontalIndex--;
        verticalCutsMade++;
        return result;
    }

    private static BigInteger getFromX(BigInteger result) {
        result = result.add(BigInteger.valueOf(verticalCutsCost[verticalIndex] * verticalCutsMade));
        verticalIndex--;
        horizontalCutsMade++;
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

            horizontalCutsCost = new long[m - 1];

            String[] cost_yItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m - 1; i++) {
                long cost_yItem = Long.parseLong(cost_yItems[i]);
                horizontalCutsCost[i] = cost_yItem;
            }

            verticalCutsCost = new long[n - 1];

            String[] cost_xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n - 1; i++) {
                long cost_xItem = Long.parseLong(cost_xItems[i]);
                verticalCutsCost[i] = cost_xItem;
            }

            int result = boardCutting();
            System.out.println(result);
        }


        scanner.close();
    }
}
