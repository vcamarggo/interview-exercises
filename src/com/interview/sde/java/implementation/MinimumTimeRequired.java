package com.interview.sde.java.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/minimum-time-required/problem
public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long temp = goal / machines.length == 0 ? 1 : goal / machines.length;

        long min = (long) Math.ceil(temp) * Arrays.stream(machines).min().getAsLong();

        long max = (long) Math.ceil(temp) * Arrays.stream(machines).max().getAsLong();


        long day;
        while (min < max) {
            day = (long) Math.floor((min + max) / 2);

            long sum = 0;
            for (Long number : machines) {
                sum += (long) Math.floor(day / number);
            }
            if (sum >= goal) {
                max = day;
            } else {
                min = day + 1;
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

