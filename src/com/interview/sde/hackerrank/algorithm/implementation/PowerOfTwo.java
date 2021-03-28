package com.interview.sde.hackerrank.algorithm.implementation;

//https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n > 1) {
            double max = Math.sqrt(n);
            for (int i = 0; i <= max + 1; i++) {
                if (n == Math.pow(2, i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
