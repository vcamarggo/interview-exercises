package com.interview.sde.java.advanced;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

//https://www.hackerrank.com/challenges/prime-checker/problem
class Prime {
    public void checkPrime(int... possiblePrimes) {
        for (int i : possiblePrimes) {
            if (BigInteger.valueOf(i).isProbablePrime(1)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class PrimeChecker {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

