package com.interview.sde.algorithm.binary;

//https://leetcode.com/problems/add-binary/
public class AddBinary {
    String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
