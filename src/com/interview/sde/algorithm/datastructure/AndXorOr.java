package com.interview.sde.algorithm.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class AndXorOr {
    private static final Scanner scanner = new Scanner(System.in);

    static long andXorOrSlow(int[] numbers) {
        int maxIndex = -1;
        int maxNumber = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (maxNumber < numbers[i]) {
                maxNumber = numbers[i];
                maxIndex = i;
            }
        }

        ArrayList<Integer> bigNumbersIndex = new ArrayList<>();
        bigNumbersIndex.add(maxIndex);

        long maskBits = Math.round(Math.pow(2, Integer.toBinaryString(maxNumber).length() - 1));

        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] & maskBits) != 0) {
                bigNumbersIndex.add(i);
            }
        }

        long max = 0;

        for (int bigIndex : bigNumbersIndex) {
            for (int i = bigIndex + 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[bigIndex]) {
                    max = Math.max(max, numbers[bigIndex] ^ numbers[i]);
                    break;
                }
            }

            for (int i = bigIndex - 1; i >= 0; i--) {
                if (numbers[i] < numbers[bigIndex]) {
                    max = Math.max(max, numbers[bigIndex] ^ numbers[i]);
                    break;
                }
            }

        }
        return max;
    }

    static int andXorOrFast(int[] numbers) {//fast
        Stack<Integer> stackPairs = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            while (!stackPairs.isEmpty()) {
                int topStack = stackPairs.peek();
                max = Math.max(max, number ^ topStack);

                if (number < topStack) {
                    stackPairs.pop();
                }
            }
            stackPairs.push(number);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long result = andXorOrFast(a);

        System.out.println(result);
    }

}
