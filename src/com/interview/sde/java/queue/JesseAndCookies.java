package com.interview.sde.java.queue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/jesse-and-cookies/problem
public class JesseAndCookies {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        PriorityQueue<Integer> cookies = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            cookies.add(scanner.nextInt());
        }

        int operations = 0;
        while (cookies.size() > 1 && cookies.peek() < k) {
            operations++;
            int cookieMin = cookies.remove();
            int cookieSecondMin = cookies.remove();
            cookies.add(cookieMin + (cookieSecondMin * 2));
        }
        if (cookies.peek() < k) {
            operations = -1;
        }

        bufferedWriter.write(String.valueOf(operations));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}

