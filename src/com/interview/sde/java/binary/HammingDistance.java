package com.interview.sde.java.binary;

//https://leetcode.com/problems/hamming-distance/
//https://leetcode.com/problems/number-of-1-bits/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
