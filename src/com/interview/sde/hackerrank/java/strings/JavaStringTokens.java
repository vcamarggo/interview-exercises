package com.interview.sde.hackerrank.java.strings;

import java.util.Scanner;

public class JavaStringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] splitedStringArray = s.trim().split("[ !,?._'@]+");

        if (s == null || s.trim().equals("")) {
            System.out.println("0");
        } else if (s.length() > 400000) {
            return;
        } else {
            System.out.println(splitedStringArray.length);
        }

        for (String word : splitedStringArray) {
            System.out.println(word);
        }
        scan.close();
    }
}


