package com.interview.sde.java.array;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximizeDistance {

    static int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                end++;
                if (start == 0) {
                    //Left padded solution
                    maxDistance = Math.max(maxDistance, (end - start));
                } else if (end == seats.length - 1 && seats[end] == 0) {
                    //Right padded solution
                    maxDistance = Math.max(maxDistance, 1 + (end - start));
                } else {
                    //Middle solution
                    maxDistance = Math.max(maxDistance, (1 + end - start) / 2);
                }
            } else {
                //restart counters
                start = i + 1;
                end = i + 1;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println("Result: " + maxDistToClosest(new int[]{0, 1, 0, 0, 0, 1, 0})); // 2
        System.out.println("Result: " + maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1})); // 2
        System.out.println("Result: " + maxDistToClosest(new int[]{1, 0, 0, 0, 0, 1, 0, 1})); // 2
        System.out.println("Result: " + maxDistToClosest(new int[]{1, 0, 0, 0, 0, 0, 1, 0, 1})); // 3
        System.out.println("Result: " + maxDistToClosest(new int[]{0, 1, 0, 0, 0, 0})); // 4
        System.out.println("Result: " + maxDistToClosest(new int[]{0, 0, 1})); // 2
        System.out.println("Result: " + maxDistToClosest(new int[]{1, 0, 1})); // 1
        System.out.println("Result: " + maxDistToClosest(new int[]{1, 0})); // 1
        System.out.println("Result: " + maxDistToClosest(new int[]{0, 1})); // 1
    }
}
