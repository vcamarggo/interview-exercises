package com.interview.sde.algorithm.search;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/jump-game-iii
public class JumpGameIII {
    final Boolean[] memo = new Boolean[500000];
    final Set<Integer> visited = new HashSet<>();
    public boolean canReach(int[] nums, int startIndex) {
        if (startIndex < 0 || startIndex >= nums.length || visited.contains(startIndex)) return false;
        if (memo[startIndex] != null) return memo[startIndex];

        if (nums[startIndex] == 0) {
            memo[startIndex] = true;
            return memo[startIndex];
        }

        visited.add(startIndex);

        if (canReach(nums, startIndex + nums[startIndex]) || canReach(nums, startIndex - nums[startIndex])) {
            memo[startIndex] = true;
            return memo[startIndex];
        }
        memo[startIndex] = false;
        return memo[startIndex];
    }
}
