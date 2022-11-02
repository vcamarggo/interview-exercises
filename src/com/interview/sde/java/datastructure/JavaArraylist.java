package com.interview.sde.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-arraylist/problem
public class JavaArraylist {

    public static List<Integer> parseLine(String line) {
        String[] numbersAsString = line.substring(line.indexOf(" ") + 1).split(" ");
        List<Integer> numberAsInteger = new ArrayList<>();
        if (numbersAsString[0].equals("0")) return numberAsInteger;
        for (String str : numbersAsString) {
            numberAsInteger.add(Integer.valueOf(str));
        }
        return numberAsInteger;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nLines = Integer.parseInt(scan.nextLine());

        List<List<Integer>> numbersList = new ArrayList<>();
        //System.out.println(nLines);
        for (; nLines > 0; nLines--) {
            //System.out.println(scan.nextLine());
            numbersList.add(parseLine(scan.nextLine()));
        }

        int nQueries = scan.nextInt();
        //System.out.println(nQueries);

        for (; nQueries > 0; nQueries--) {
            int listIndex = scan.nextInt() - 1;
            int elementIndex = scan.nextInt() - 1;
            try {
                System.out.println(numbersList.get(listIndex).get(elementIndex));
            } catch (IndexOutOfBoundsException obe) {
                System.out.println("ERROR!");
            }
        }
    }
}


