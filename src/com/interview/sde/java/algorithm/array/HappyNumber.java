package com.interview.sde.algorithm.array;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int newN = 0;
            while (n > 0) {
                int digit = n % 10;
                newN += digit * digit;
                n /= 10;
            }
            n = newN;
        }
        return n == 1;
    }
}
