package com.interview.sde.java.binary;

//https://leetcode.com/problems/flipping-an-image/
public class FlipInvertMatrix {

    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        for(int row = 0; row < n; row++){
            int[] newImage = new int[n];

            for(int column = 0; column < n; column++){
                newImage[column] = image[row][n-1-column] ^ 1;
            }
            image[row] = newImage;
        }

        return image;
    }

}
