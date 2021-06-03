package com.interview.sde.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class ClimbingLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] alicePosition = new int[alice.length];
        scores = IntStream.of(scores).distinct().sorted().toArray();

        for (int i = 0; i < alice.length; i++) {
            int index = Arrays.binarySearch(scores, alice[i]);
            if (index < 0) index = -index - 2;
            alicePosition[i] = scores.length - index;
        }
        return alicePosition;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int value : result) {
            System.out.println(value);

        }
        scanner.close();
    }
}

