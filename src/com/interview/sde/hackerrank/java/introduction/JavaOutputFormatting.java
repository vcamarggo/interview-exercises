package com.interview.sde.hackerrank.java.introduction;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-output-formatting/problem
public class JavaOutputFormatting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int j = 0; j < 3; j++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            s1 = s1.trim();
            for (int i = 0; i < 15; i++) {
                if (i < s1.length()) {
                    System.out.print(s1.charAt(i));
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println(x > 99 ? x : x > 9 ? "0" + x : "00" + x);
        }
        System.out.println("================================");

    }
}




