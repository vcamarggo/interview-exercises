package com.interview.sde.hackerrank.java.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-list/problem
public class JavaList {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        ArrayList<Integer> n = new ArrayList<>();

        for (String numberAsString : scanner.nextLine().split(" ")) {
            n.add(Integer.parseInt(numberAsString));
        }

        int queryNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < queryNumber; i++) {
            String query = scanner.nextLine();
            int[] queryData = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (query.equals("Insert")) {
                n.add(queryData[0], queryData[1]);
            } else {
                n.remove(queryData[0]);
            }
        }
        n.forEach(d -> System.out.print(d + " "));
        scanner.close();
    }
}


