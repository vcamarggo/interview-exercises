package com.interview.sde.hackerrank.algorithm.implementation;

import java.util.stream.IntStream;

//https://leetcode.com/problems/rotated-digits/
public class RotatedDigits {
    int rotatedDigits(int N) {
        return IntStream.rangeClosed(1, N).filter(this::isRotated).sum();
    }

//Faster but more verbose
//    int rotatedDigits(int N) {
//        int count = 0;
//        for (int i = 1; i <= N; i++) {
//            if (isRotated(i)) {
//                count++;
//            }
//        }
//        return count;
//    }

    public boolean isRotated(int N) {
        boolean isRotated = false;
        while (N > 0) {
            int digit = N % 10;

            if (digit == 7 || digit == 3 || digit == 4) return false;
            if (!isRotated) {
                isRotated = (digit == 2 || digit == 5 || digit == 6 || digit == 9);
            }
            N /= 10;
        }
        return isRotated;
    }
}
