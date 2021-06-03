package com.interview.sde.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/marcs-cakewalk/problem
public class MarcCakewalk {

    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(Integer[] calories) {
        Arrays.sort(calories, (o1, o2) -> Integer.compare(o2, o1));
        long sum = 0;
        for (int i = 0; i < calories.length; i++) {
            sum += (calories[i] * Math.pow(2, i));
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] calorie = new Integer[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);
        System.out.println(result);

        scanner.close();
    }
}
