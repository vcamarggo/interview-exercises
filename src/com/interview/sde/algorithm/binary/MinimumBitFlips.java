package com.interview.sde.algorithm.binary;

//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
public class MinimumBitFlips {
    static int minBitFlips(int start, int goal) {
        // my original idea
        // (int) Integer.toBinaryString(start ^ goal).chars().filter(c -> c == '1').count()
        return Integer.bitCount(start ^ goal);
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(minBitFlips(1, 2));
        System.out.println(minBitFlips(3, 4));
    }

}
