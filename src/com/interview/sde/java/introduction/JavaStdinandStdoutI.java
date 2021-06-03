package com.interview.sde.java.introduction;
//https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem

import java.util.Scanner;

public class JavaStdinandStdoutI {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext())
            System.out.println(scan.nextInt());
    }
}


