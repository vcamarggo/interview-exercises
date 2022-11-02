package com.interview.sde.java.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/triple-sum/problem
public class TripleSum {

    // Complete the triplets function below.
    static long triplets(int[] ae, int[] be, int[] ce) {
        long counter = 0;

        int[] a = Arrays.stream(ae).sorted().distinct().toArray();
        int[] b = Arrays.stream(be).sorted().distinct().toArray();
        int[] c = Arrays.stream(ce).sorted().distinct().toArray();

        for (int i : b) {
            int aIndex;
            int cIndex;
            for (aIndex = i > a.length ? a.length - 1 : i - 1;
                 aIndex >= 0 && a[aIndex] > i; aIndex--) {
            }
            for (cIndex = i > c.length ? c.length - 1 : i - 1;
                 cIndex >= 0 && c[cIndex] > i; cIndex--) {
            }
            counter += (((long) aIndex + 1) * ((long) cIndex + 1));
        }
        return counter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

