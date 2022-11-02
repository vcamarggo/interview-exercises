package com.interview.sde.algorithm.binary;

//https://leetcode.com/problems/hamming-distance/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
