package com.interview.sde.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;

//https://www.hackerrank.com/challenges/java-bigdecimal/problem
public class JavaBigDecimal {
    public static void main(String[] args) {
        String[] s = null;
        Arrays.sort(s, (o1, o2) -> {
            if (o1 == null || o2 == null) {
                return 0;
            }
            BigDecimal b1 = new BigDecimal(o1);
            BigDecimal b2 = new BigDecimal(o2);

            return b2.compareTo(b1);
        });
    }
}
