package com.interview.sde.java.string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
public class SherlockandAnagrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        String substring;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substring = s.substring(i, j);
                char[] tempArray = substring.toCharArray();
                Arrays.sort(tempArray);
                String orderedSubstring = new String(tempArray);

                System.out.println(orderedSubstring);

                if (map.containsKey(orderedSubstring)) {
                    System.out.println("contains");
                    int value = map.get(orderedSubstring);
                    count = count + value;

                    // Increment the times we've seen the string
                    map.put(orderedSubstring, value + 1);
                } else {
                    System.out.println("notcontains");
                    map.put(orderedSubstring, 1);
                }
            }
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

