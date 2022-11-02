package com.interview.sde.java.binary;

import java.math.BigInteger;

//https://leetcode.com/problems/add-binary/
public class AddBinary {
    public String addBinary(String a, String b) {
        return new BigInteger(a,2).add(new BigInteger(b,2)).toString(2);
    }
}
