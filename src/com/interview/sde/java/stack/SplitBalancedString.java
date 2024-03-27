package com.interview.sde.java.stack;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/split-a-string-in-balanced-strings
public class SplitBalancedString {

    public int balancedStringSplitSlow(String s) {
        Deque<Character> st = new LinkedList<>();
        int balanced = 0;
        for(Character c : s.toCharArray()){
            if(st.isEmpty() || st.peek() == c){
                st.push(c);
            } else {
                st.pop();
                if(st.isEmpty()) balanced++;
            }
        }

        return balanced;
    }
    public int balancedStringSplitFast(String s) {
        short r = 0;
        int balanced = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'R') {
                r++;
            } else {
                r--;
            }
            if (r == 0) balanced++;
        }

        return balanced;
    }
}
