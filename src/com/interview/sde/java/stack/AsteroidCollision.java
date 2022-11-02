package com.interview.sde.java.stack;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> result = new Stack<>();
        for (Integer asteroid : asteroids) {
            while (!result.isEmpty() && asteroid < 0 && result.peek() > 0) {
                int top = result.pop();
                int asteroidSize = Math.abs(asteroid);
                int topSize = Math.abs(top);
                if (asteroidSize == topSize) {
                    asteroid = null;
                    break;
                }
                asteroid = asteroidSize > topSize ? asteroid : top;
            }
            if (asteroid != null) {
                result.push(asteroid);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        new AsteroidCollision().asteroidCollision(new int[]{5, 10, -5});
        new AsteroidCollision().asteroidCollision(new int[]{8, -8});
        new AsteroidCollision().asteroidCollision(new int[]{10, 2, -5});
        new AsteroidCollision().asteroidCollision(new int[]{-2, -1, 1, 2});
    }
}
