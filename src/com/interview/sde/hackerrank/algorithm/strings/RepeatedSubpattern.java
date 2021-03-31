package com.interview.sde.hackerrank.algorithm.strings;

//https://leetcode.com/problems/repeated-substring-pattern
public class RepeatedSubpattern {
    public boolean repeatedSubstringPattern(String s) {
        int sLength = s.length();
        for(int i = 1 ; i < sLength ; i++){

            if(sLength % i == 0){ //if string can be split in parts of the same size
                String mustBeEqual = s.substring(0,i);
                boolean allEqual = true;

                //test all string starting at 0+offset i
                for(int internalIndex = i ; internalIndex < sLength && allEqual; internalIndex += i){
                    if(!s.substring(internalIndex,internalIndex+i).equals(mustBeEqual)){
                        allEqual = false;
                    }
                }

                if(allEqual){
                    return true;
                }
            }
        }

        return false;
    }
}
