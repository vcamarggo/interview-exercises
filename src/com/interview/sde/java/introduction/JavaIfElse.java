package com.interview.sde.java.introduction;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-if-else/problem
public class JavaIfElse {

/*If n is odd, print Weird
If n is even and in the inclusive range of to 2,5 print Not Weird
If n is even and in the inclusive range of to 6,20, print Weird
If n is even and greater than , print Not Weird*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (n % 2 == 1) {
            System.out.println("Weird");
        } else if (n > 1 && n < 6) {
            System.out.println("Not Weird");
        } else if (n <= 20) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }

        scanner.close();
    }
}

