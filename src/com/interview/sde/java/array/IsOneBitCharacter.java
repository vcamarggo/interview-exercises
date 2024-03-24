package com.interview.sde.java.array;

//https://leetcode.com/problems/1-bit-and-2-bit-characters/
public class IsOneBitCharacter {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while (idx < bits.length - 1) {
            idx += (bits[idx] == 0) ? 1 : 2;
        }
        return idx == bits.length - 1;
    }

}
