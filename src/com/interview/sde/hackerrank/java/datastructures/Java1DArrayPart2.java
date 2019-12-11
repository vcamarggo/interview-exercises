package com.interview.sde.hackerrank.java.datastructures;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-1d-array/problem
public class Java1DArrayPart2 {

    public static boolean canWin(int[] game, int leap, int i) {
        if (i >= game.length)
            return true;
        if (game[i] == 0) {
            game[i] = 1;
            if (canWin(game, leap, i + leap)) {
                return true;
            }
            if (canWin(game, leap, i + 1)) {
                return true;
            }
            if (i > 0) {
                return canWin(game, leap, i - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(game, leap, 0)) ? "YES" : "NO");
        }
        scan.close();
    }
}

