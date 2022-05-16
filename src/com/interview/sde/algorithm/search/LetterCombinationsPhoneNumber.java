package com.interview.sde.algorithm.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number
public class LetterCombinationsPhoneNumber {
    final static Map<Character, List<Character>> keyboard = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );

    public static List<String> letterCombinations(String digits) {
        List<String> solution = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            Character currentDigit = digits.charAt(i);

            int temporarySolutionSize = Math.max(1, solution.size());

            List<String> permutations = new ArrayList<>();
            for (Character value : keyboard.get(currentDigit)) {

                String valueAsString = String.valueOf(value);
                for (int j = 0; j < temporarySolutionSize; j++) {
                    if (temporarySolutionSize > 1) {
                        //append the previous result with the new digit, this allow to create all possible permutations
                        permutations.add(solution.get(j).concat(valueAsString));
                    } else {
                        //create the first layer of one digit "".concat(valueAsString)
                        permutations.add(valueAsString);
                    }
                }
            }
            solution = permutations;
        }

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("5"));
    }
}
