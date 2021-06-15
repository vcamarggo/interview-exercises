package com.interview.sde.algorithm.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/pairs/problem
public class Pairs {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        int count = 0;

        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int first = i - k;
            if (first < 0) {
                first = 0;
            }
            int last = i;

            // System.out.println(first);
            // System.out.println(last);
            // System.out.println(mid);

            while (first <= last) {
                int mid = (last + first) / 2;

                int diff = arr[i] - arr[mid];
                if (diff == k) {
                    count++;
                    break;
                } else if (diff < k) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

