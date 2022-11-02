package com.interview.sde.algorithm.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/truck-tour/
public class TruckTour {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the truckTour function below.
     */
    static int truckTour(int[][] petroleumPumps) {
        int i = 0;
        for (; i < petroleumPumps.length; i++) {
            if (petroleumPumps[i][0] > petroleumPumps[i][1]) {
                int tank = petroleumPumps[i][0] - petroleumPumps[i][1];
                int k = i + 1;
                while (tank > 0) {
                    tank += petroleumPumps[k][0] - petroleumPumps[k][1];
                    k++;
                    if (k >= petroleumPumps.length) {
                        k = 0;
                    } else if (k == i) {
                        return i;
                    }
                }
            }
        }
        return i;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

