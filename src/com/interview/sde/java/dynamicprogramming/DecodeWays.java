package com.interview.sde.java.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    final Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("106"));
        System.out.println(new DecodeWays().numDecodings("06"));
//        System.out.println(new DecodeWays().numDecodings("23"));
        System.out.println(new DecodeWays().numDecodings("226"));
//        System.out.println(new DecodeWays().numDecodings("13"));
//        System.out.println(new DecodeWays().numDecodings("134"));
        System.out.println(new DecodeWays().numDecodings("1314"));
    }

    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }

    public int numDecodings(String s, int current) {

        if (!memo.containsKey(current)) {

            //grouped the right size
            if (current == s.length()) {
                memo.put(current, 1);
                return 1;
            }

            //tried to group something out of string boundary or start a grouping with zero
            if (current > s.length() || s.charAt(current) == '0') {
                memo.put(current, 0);
                return 0;
            }

            int decoding = 0;
            if (s.charAt(current) == '1') {
                // every time we see a '1' we can group with the next 10 (j) to 19 (s)
                decoding += numDecodings(s, current + 2);
            }

            // try to group number if in range of 20 (t) to 26 (z)
            if (s.charAt(current) == '2' && s.length() > current + 1 && s.charAt(current + 1) <= '6') {
                decoding += numDecodings(s, current + 2);
            }

            //consider number individually
            decoding += numDecodings(s, current + 1);

            memo.put(current, decoding);
        }

        return memo.get(current);
    }

}
