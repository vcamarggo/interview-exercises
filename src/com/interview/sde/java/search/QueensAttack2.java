package com.interview.sde.java.search;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttack2 {

    private static final Scanner scanner = new Scanner(System.in);

    static int queensAttack(int boardSize, int rowQueen, int columnQueen, int[][] obstacles) {
        rowQueen = boardSize + 1 - rowQueen;

        int totalAttacks = 0;

        int rowTop = -1;

        int rowBottom = -1;

        int columnLeft = -1;

        int columnRight = -1;

        int rowTopLeft = -1;
        int columnTopLeft = -1;

        int rowTopRight = -1;
        int columnTopRight = -1;

        int rowBottomRight = -1;
        int columnBottomRight = -1;

        int rowBottomLeft = -1;
        int columnBottomLeft = -1;

        for (int[] obstacle : obstacles) {
            int rowObstacle = boardSize + 1 - obstacle[0];
            int columnObstacle = obstacle[1];

            //Top
            if ((rowObstacle < rowTop || rowTop == -1) && rowObstacle < rowQueen && columnObstacle == columnQueen) {
                rowTop = rowObstacle;
            }

            //Bottom
            if ((rowObstacle > rowBottom || rowBottom == -1) && rowObstacle > rowQueen && columnObstacle == columnQueen) {
                rowBottom = rowObstacle;
            }

            //Left
            if ((columnObstacle < columnLeft || columnLeft == -1) && columnObstacle < columnQueen && rowObstacle == rowQueen) {
                columnLeft = columnObstacle;
            }

            //Right
            if ((columnObstacle > columnRight || columnRight == -1) && columnObstacle > columnQueen && rowObstacle == rowQueen) {
                columnRight = columnObstacle;
            }

            //TopRight
            if (rowQueen - rowObstacle == columnObstacle - columnQueen && columnObstacle > columnQueen
                    && rowObstacle < rowQueen && ((rowObstacle > rowTopRight && columnObstacle < columnTopRight) || rowTopRight == -1)) {
                columnTopRight = columnObstacle;
                rowTopRight = rowObstacle;
            }

            //TopLeft
            if (rowQueen - rowObstacle == columnQueen - columnObstacle && columnObstacle < columnQueen
                    && rowObstacle < rowQueen && ((rowObstacle > rowTopLeft && columnObstacle > columnTopLeft) || rowTopLeft == -1)) {
                columnTopLeft = columnObstacle;
                rowTopLeft = rowObstacle;
            }

            //BottomRight
            if (rowObstacle - rowQueen == columnObstacle - columnQueen && columnObstacle > columnQueen
                    && rowObstacle > rowQueen && ((rowObstacle < rowBottomRight && columnObstacle < columnBottomRight) || rowBottomRight == -1)) {
                columnBottomRight = columnObstacle;
                rowBottomRight = rowObstacle;
            }

            //BottomLeft
            if (rowObstacle - rowQueen == columnQueen - columnObstacle && columnObstacle < columnQueen
                    && rowObstacle > rowQueen && ((rowObstacle < rowBottomLeft && columnObstacle > columnBottomLeft) || rowBottomLeft == -1)) {
                columnBottomLeft = columnObstacle;
                rowBottomLeft = rowObstacle;
            }
        }

        totalAttacks += (columnRight != -1) ? (columnRight - columnQueen - 1) : boardSize - columnQueen;
        totalAttacks += (columnLeft != -1) ? (columnQueen - columnLeft - 1) : columnQueen - 1;
        totalAttacks += (rowTop != -1) ? (rowQueen - rowTop - 1) : rowQueen - 1;
        totalAttacks += (rowBottom != -1) ? (rowBottom - rowQueen - 1) : boardSize - rowQueen;

        //BottomRight
        totalAttacks += (rowBottomRight != -1) ? (columnBottomRight - columnQueen - 1) : Math.min(boardSize - columnQueen, boardSize - rowQueen);
        //BottomLeft
        totalAttacks += (rowBottomLeft != -1) ? (columnQueen - columnBottomLeft - 1) : Math.min(columnQueen - 1, boardSize - rowQueen);
        //TopLeft
        totalAttacks += (columnTopLeft != -1) ? (columnQueen - columnTopLeft - 1) : Math.min(columnQueen - 1, rowQueen - 1);
        //TopRight
        totalAttacks += (rowTopRight != -1) ? (columnTopRight - columnQueen - 1) : Math.min(boardSize - columnQueen, rowQueen - 1);

        return totalAttacks;
    }

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }

}

