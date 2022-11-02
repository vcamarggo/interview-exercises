package com.interview.sde.algorithm.search;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/the-grid-search/problem
public class TheGridSearch {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        for (int i = 0; i <= G.length - P.length; i++) {
            for (int j = 0; j <= G[0].length() - P[0].length(); j++) {
                if (G[i].charAt(j) == P[0].charAt(0)
                        && G[i + P.length - 1].charAt(j) == P[P.length - 1].charAt(0)

                        && G[i].charAt(j + P[0].length() - 1) == P[0].charAt(P[0].length() - 1)

                        && G[i + P.length - 1].charAt(j + P[0].length() - 1) == P[P.length - 1].charAt(P[0].length() - 1)) {
                    boolean found = true;
                    for (int k = 0; k < P.length && found; k++) {
                        for (int l = 0; l < P[0].length(); l++) {
                            if (G[i + k].charAt(j + l) != P[k].charAt(l)) {
                                found = false;
                                break;
                            }
                        }
                    }
                    if (found) {
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            System.out.println(result);
        }


        scanner.close();
    }
}

