package com.interview.sde.java.introduction;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-static-initializer-block/problem
public class JavaStaticInitializerBlock {

    static int B;
    static int H;
    static boolean flag = false;

    static {
        Scanner scan = new Scanner(System.in);
        B = scan.nextInt();
        H = scan.nextInt();
        if (B <= 0 || H <= 0) {
            System.out.print("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }

    }


}
