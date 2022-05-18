package com.interview.sde.algorithm.search;

//https://leetcode.com/problems/island-perimeter/
public class IslandPerimeter {
    static int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1){
                    perimeter += row - 1 < 0 || grid[row - 1][column] != 1 ? 1 : 0;
                    perimeter += column - 1 < 0 || grid[row][column - 1] != 1 ? 1 : 0;
                    perimeter += row + 1 >= grid.length || grid[row + 1][column] != 1 ? 1 : 0;
                    perimeter += column + 1 >= grid[0].length || grid[row][column+1] != 1 ? 1 : 0;
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                        new int[]{0,1,0,0},
                        new int[]{1,1,1,0},
                        new int[]{0,1,0,0},
                        new int[]{1,1,0,0},}));
    }
}
