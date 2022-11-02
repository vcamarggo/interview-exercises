package com.interview.sde.java.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/two-arrays/problem
public class PermutingTwoArrays {
    // Complete the twoArrays function below.
    static String twoArrays(int k, Integer[] A, Integer[] B) {
        Arrays.sort(A, Comparator.naturalOrder());
        Arrays.sort(B, Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[i] < k) return "NO";
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            Integer[] A = new Integer[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            Integer[] B = new Integer[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            String result = twoArrays(k, A, B);
            System.out.println(result);
        }
        System.out.println();

        scanner.close();
    }
}

