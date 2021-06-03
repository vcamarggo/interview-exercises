package com.interview.sde.java.introduction;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-loops/problem
public class JavaLoopsII {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int temp = a;
            for (int j = 0; j < n; j++) {
                temp = temp + (int) Math.pow(2, j) * b;
                System.out.print(temp + " ");
            }
            System.out.println();
        }
        in.close();
    }
}


