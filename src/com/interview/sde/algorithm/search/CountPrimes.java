package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[1];
        if (n > prime.length) {
            prime = new boolean[n + 1];
            for (int i = 0; i < n; i++)
                prime[i] = true;

            for (int p = 2; p * p < n; p++) {
                if (prime[p]) {
                    for (int i = p * 2; i < n; i += p)
                        prime[i] = false;
                }
            }
        }

        int primeCounter = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primeCounter++;
        }
        return primeCounter;
    }
}
