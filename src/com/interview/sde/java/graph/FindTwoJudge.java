package com.interview.sde.java.graph;

//https://leetcode.com/problems/find-the-town-judge/
public class FindTwoJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustedByCounter = new int[n + 1];

        for (int[] zeroTrustOne : trust) {
            trustedByCounter[zeroTrustOne[0]]--;
            trustedByCounter[zeroTrustOne[1]]++;
        }

        for (int i = 1; i < trustedByCounter.length; i++) {
            if (trustedByCounter[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
