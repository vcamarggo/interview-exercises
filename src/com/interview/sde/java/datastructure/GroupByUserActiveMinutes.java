package com.interview.sde.java.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/finding-the-users-active-minutes/
public class GroupByUserActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //This must be used because a user can have N activities at the same minute
        Map<Integer, Set<Integer>> userActiveMinutes = new HashMap<>();
        int[] usersActiveByMinute = new int[k];

        for (int[] activity : logs) {
            int user = activity[0];
            int activityMinute = activity[1];
            if (userActiveMinutes.containsKey(user)) {
                if (userActiveMinutes.get(user).add(activityMinute)) {
                    int minute = userActiveMinutes.get(user).size();
                    //The array is 1-indexed
                    int previousMinuteIndex = minute - 2;
                    int currentMinuteIndex = minute - 1;
                    //Remove one from the previous user size, add one to the current
                    usersActiveByMinute[previousMinuteIndex]--;
                    usersActiveByMinute[currentMinuteIndex]++;
                }
            } else {
                userActiveMinutes.compute(user, (key, value) -> new HashSet<>()).add(activityMinute);
                //The array is 1-indexed
                int currentMinuteIndex = 0;
                usersActiveByMinute[currentMinuteIndex]++;
            }
        }

        return usersActiveByMinute;
    }
}
