package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/count-and-say/
public class CountSay {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        while (--n > 0) {

            StringBuilder nextCountSay = new StringBuilder();
            String currentCountSay = result.toString();
            char prevNumber = currentCountSay.charAt(0);
            int count = 1;

            for (int i = 1; i < currentCountSay.length(); i++) {
                if (currentCountSay.charAt(i) == prevNumber) {
                    count++;
                } else {
                    nextCountSay.append(count).append(prevNumber);
                    prevNumber = currentCountSay.charAt(i);
                    count = 1;
                }
            }
            result = nextCountSay.append(count).append(prevNumber);
        }
        return result.toString();
    }
}
