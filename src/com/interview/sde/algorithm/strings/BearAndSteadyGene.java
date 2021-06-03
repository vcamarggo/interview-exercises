package com.interview.sde.algorithm.strings;

import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/bear-and-steady-gene/problem
public class BearAndSteadyGene {

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        int occurrenceOfEach = gene.length() / 4;

        HashMap<Character, Integer> geneOccurrence = new HashMap<>();
        geneOccurrence.put('C', 0);
        geneOccurrence.put('T', 0);
        geneOccurrence.put('G', 0);
        geneOccurrence.put('A', 0);

        for (int i = 0; i < gene.length(); i++) {
            Character charAtI = gene.charAt(i);
            geneOccurrence.put(charAtI, geneOccurrence.get(charAtI) + 1);
        }

        int head = 0;
        int tail = 0;
        int min = Integer.MAX_VALUE;

        while (true) {
            while ((geneOccurrence.get('C') > occurrenceOfEach ||
                    geneOccurrence.get('T') > occurrenceOfEach ||
                    geneOccurrence.get('G') > occurrenceOfEach ||
                    geneOccurrence.get('A') > occurrenceOfEach)
                    && head < gene.length()) {
                geneOccurrence.computeIfPresent(gene.charAt(head), (character, integer) -> integer - 1);
                head++;
            }

            if (head == gene.length()) {
                break;
            }

            while (geneOccurrence.get('C') <= occurrenceOfEach &&
                    geneOccurrence.get('T') <= occurrenceOfEach &&
                    geneOccurrence.get('G') <= occurrenceOfEach &&
                    geneOccurrence.get('A') <= occurrenceOfEach) {
                geneOccurrence.computeIfPresent(gene.charAt(tail), (character, integer) -> integer + 1);
                tail++;
            }

            min = Math.min((head - tail + 1), min);
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        System.out.println(result);

        scanner.close();
    }
}
