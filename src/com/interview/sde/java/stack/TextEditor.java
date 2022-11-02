package com.interview.sde.java.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.hackerrank.com/challenges/simple-text-editor/problem
public class TextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int operations = Integer.parseInt(br.readLine());

        Stack<String> history = new Stack<>();
        String currentInput = "";
        for (int i = 0; i < operations; i++) {
            String[] query = br.readLine().split(" ");
            switch (Integer.parseInt(query[0])) {
                case 1:
                    history.push(currentInput);
                    currentInput = currentInput.concat(query[1]);
                    break;
                case 2:
                    int charsToRemove = Integer.parseInt(query[1]);
                    history.push(currentInput);
                    currentInput = currentInput.substring(0, currentInput.length() - charsToRemove);
                    break;
                case 3:
                    int index = Integer.parseInt(query[1]);
                    System.out.println(currentInput.charAt(index - 1));
                    break;
                case 4:
                    if (!history.isEmpty())
                        currentInput = history.pop();
                    break;
            }
        }
    }
}
