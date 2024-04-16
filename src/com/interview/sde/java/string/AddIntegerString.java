package com.interview.sde.java.string;

//https://leetcode.com/problems/add-strings/
public class AddIntegerString {
    public String addStrings(String num1, String num2) {

        int n1Size = num1.length() - 1;
        int n2Size = num2.length() - 1;

        int maxNSize = Math.max(n1Size, n2Size);

        boolean carryOne = false;

        StringBuilder reversedSolution = new StringBuilder();

        for (int i = 0; i <= maxNSize; i++) {
            char c1 = (n1Size - i) >= 0 ? num1.charAt(n1Size - i) : '0';
            char c2 = (n2Size - i) >= 0 ? num2.charAt(n2Size - i) : '0';
            int intCharSum = c1 - '0' + c2 - '0' + (carryOne ? 1 : 0);
            carryOne = intCharSum >= 10;
            reversedSolution.append(intCharSum - (carryOne ? 10 : 0));
        }

        if (carryOne) reversedSolution.append(1);

        return reversedSolution.reverse().toString();
    }
}
