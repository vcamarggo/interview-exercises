package com.interview.sde.java.string;

//https://leetcode.com/problems/license-key-formatting/
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder key = new StringBuilder();

        int subKey = 0;

        for(int i = s.length() - 1; i >= 0 ; i--){
            char c = s.charAt(i);
            if(c != '-'){
                key.append(Character.toUpperCase(s.charAt(i)));
                subKey++;
                if(subKey == k){
                    key.append("-");
                    subKey = 0;
                }
            }

        }

        key.reverse();

        while(!key.isEmpty() && key.charAt(0) == '-'){
            key.deleteCharAt(0);
        }

        return key.toString();
    }
}
