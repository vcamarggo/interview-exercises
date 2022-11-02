package com.interview.sde.java.array;


//https://leetcode.com/problems/minimum-time-visiting-all-points/
public class MinimumStepsCartesianPoints {

    //There is a fancy way to calculate this
    //https://leetcode.com/problems/minimum-time-visiting-all-points/discuss/1133692/JAVAor-0-ms-or-100-fastor-Efficient-or-Simple
    //int xdiff=Math.abs(points[i][0]-points[i-1][0]);
    //int ydiff=Math.abs(points[i][1]-points[i-1][1]);
    //time+=Math.max(xdiff, ydiff);
    public int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int minMov = 0;
        for (int[] pair : points) {
            int targetX = pair[0];
            int targetY = pair[1];
            while (x != targetX || y != targetY) {
                if (x < targetX && y < targetY) { //upper right
                    x++;
                    y++;
                } else if (x < targetX && y > targetY) { //lower right
                    x++;
                    y--;
                } else if (x > targetX && y > targetY) { //lower left
                    x--;
                    y--;
                } else if (x > targetX && y < targetY) { //upper left
                    x--;
                    y++;
                } else if (x == targetX && y < targetY) { //upper
                    y++;
                } else if (x == targetX && y > targetY) { //lower
                    y--;
                } else if (x < targetX && y == targetY) { //right
                    x++;
                } else if (x > targetX && y == targetY) {//left
                    x--;
                }
                minMov++;
            }
        }
        return minMov;
    }
}
