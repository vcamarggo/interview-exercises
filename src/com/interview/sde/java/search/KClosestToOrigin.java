package com.interview.sde.java.search;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosestToOrigin {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}}, 2)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        return Arrays.stream(points)
                .sorted(Comparator.comparingDouble(KClosestToOrigin::calculateDistance))
                .limit(k)
                .toArray(int[][]::new);
    }

    private static double calculateDistance(int[] pair) {
        double deltaX = Math.pow(pair[0], 2);

        double deltaY = Math.pow(pair[1], 2);

        return Math.sqrt(deltaX + deltaY);
    }
}
