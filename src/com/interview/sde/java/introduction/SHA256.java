package com.interview.sde.java.introduction;

import java.security.MessageDigest;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sha-256/problem
public class SHA256 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = input.next();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(message.getBytes());
            byte[] hash = digest.digest();

            for (byte b : hash) {
                System.out.printf("%02x", b);
            }
        } catch (Exception ignored) {
        }
    }

}
