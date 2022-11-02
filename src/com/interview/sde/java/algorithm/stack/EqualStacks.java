package com.interview.sde.algorithm.stack;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/equal-stacks/problem
public class EqualStacks {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int[] accumulator1 = createAccumulator(h1);
        int[] accumulator2 = createAccumulator(h2);
        int[] accumulator3 = createAccumulator(h3);

        int index1 = accumulator1.length - 1;
        int index2 = accumulator2.length - 1;
        int index3 = accumulator3.length - 1;

        while (index1 >= 0) {
            while (index2 >= 0 && accumulator1[index1] <= accumulator2[index2]) {
                if (accumulator1[index1] == accumulator2[index2]) {
                    while (index3 >= 0 && accumulator2[index2] <= accumulator3[index3]) {
                        if (accumulator2[index2] == accumulator3[index3]) {
                            return accumulator3[index3];
                        }
                        index3--;
                    }
                }
                index2--;
            }
            index1--;
        }

        return 0;
    }

    private static int[] createAccumulator(int[] from) {
        int[] accumulator = new int[from.length];
        accumulator[0] = from[from.length - 1];
        for (int i = from.length - 1; i > 0; i--) {
            accumulator[from.length - i] = accumulator[from.length - i - 1] + from[i - 1];
        }
        return accumulator;
    }

    public static void main(String[] args) {

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println(result);

    }
}
