package com.interview.sde.algorithm.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/caesar-cipher-1/problem
public class CaesarCipher {

    static String caesarCipher(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int charAscCode = charArray[i];
            int rotatedAscCode = charAscCode + k;
            if (charAscCode >= 65 && charAscCode <= 90) {
                if (charAscCode + k > 90) {
                    rotatedAscCode = 64 + (charAscCode + k - 90);
                }
                charArray[i] = (char) rotatedAscCode;
            } else if (charAscCode >= 97 && charAscCode <= 122) {
                if (charAscCode + k > 122) {
                    rotatedAscCode = 96 + (charAscCode + k - 122);
                }
                charArray[i] = (char) rotatedAscCode;
            }
        }
        return new String(charArray);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt() % 26;
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
