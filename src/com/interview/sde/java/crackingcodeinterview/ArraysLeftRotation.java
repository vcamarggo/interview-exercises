package com.interview.sde.crackingcodeinterview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
public class ArraysLeftRotation {

    // Complete the rotLeft function below.
    static List<Integer> rotLeft(List<Integer> a, int d) {
        Collections.rotate(a, -d);
        return a;
    }

    static int[] rotLeft(int[] a, int d) {
        int[] rotated = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a.length - 1 >= d + i) {
                rotated[i] = a[i + d];
            } else {
                rotated[i] = a[i + d - a.length];
            }
        }
        return rotated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        List<Integer> a = new ArrayList<>();

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        List<Integer> result = rotLeft(a, d);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

