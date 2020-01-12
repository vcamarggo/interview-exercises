package com.interview.sde.hackerrank.java.advanced;

import java.security.MessageDigest;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-md5/problem
public class MD5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = input.next();

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(message.getBytes());
            byte[] hash = digest.digest();

            for (byte b : hash) {
                System.out.printf("%02x", b);
            }
        } catch (Exception ignored) {
        }
    }

}
