package com.interview.sde.java.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
public class FindWinnerCircle {
    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            players.add(i);
        }

        int nextKill = 0;
        while (players.size() > 1) {
            //k-1 because list is 0 based
            nextKill = (nextKill + k - 1) % players.size();
            players.remove(nextKill);
        }

        return players.get(0);
    }
}
