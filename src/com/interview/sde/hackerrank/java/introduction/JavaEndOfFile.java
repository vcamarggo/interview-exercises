package com.interview.sde.hackerrank.java.introduction;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-end-of-file/problem
public class JavaEndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        for (int i = 1; scan.hasNext(); i++)
            System.out.println(i + " " + scan.nextLine());
    }
}


