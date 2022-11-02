package com.interview.sde.crackingcodeinterview;

import java.util.Scanner;

public class ArraysNewYearChaos {

    static void minimumBribes(int[] q) {
        int counter = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] > i + 3) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int rightPosition = 0;
        for (int i = q.length - 1; i > 0; i--) {
            for (int j = rightPosition; j < i; j++) {
                if (q[j] > q[j + 1]) {
                    counter++;
                    int aux = q[j];
                    q[j] = q[j + 1];
                    q[j + 1] = aux;
                }
                if (q[j] == j + 1 && rightPosition + 1 == j) {
                    rightPosition = j;
                }
            }
        }

        System.out.println(counter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}


