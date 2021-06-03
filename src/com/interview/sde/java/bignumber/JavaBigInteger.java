package com.interview.sde.java.bignumber;

import java.math.BigInteger;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-biginteger/problem
public class JavaBigInteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger b1 = new BigInteger(scan.next());
        BigInteger b2 = new BigInteger(scan.next());

        System.out.println(b1.add(b2));
        System.out.println(b1.multiply(b2));
    }
}


