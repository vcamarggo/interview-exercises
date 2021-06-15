package com.interview.sde.algorithm.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReverseVowels {
    public String reverseVowels(String s) {

        //Over allocating memory, probably can be done with less objects.
        //Idea: Concatenating the array at the end of the sb and then replacing/removing then on the next loop
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> vowelsOrder = new Stack<>();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (vowels.contains(charAtI)) {
                vowelsOrder.push(charAtI);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (vowels.contains(charAtI)) {
                sb.replace(i, i + 1, String.valueOf(vowelsOrder.pop()));
            }
        }
        return sb.toString();
    }
}
