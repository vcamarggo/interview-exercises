package com.interview.sde.hackerrank.java.strings;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-strings-introduction/problem
public class JavaStringsIntroduction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(Character.toString(A.charAt(0)).toUpperCase() + A.substring(1) + " " + Character.toString(B.charAt(0)).toUpperCase() + B.substring(1));

    }
}




