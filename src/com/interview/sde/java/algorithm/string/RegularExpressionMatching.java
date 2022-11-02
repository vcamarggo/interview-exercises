package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {


    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aaabc", "a*b.*"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("ssissippi", "s*is*p*."));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b*"));
        System.out.println(new RegularExpressionMatching().isMatch("a", "ab*"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*c"));
    }

    public boolean isMatch(String s, String p) {
        //String s matches the pattern p
        if (s.equals(p)) {
            return true;
        }

        //Pattern finished without matching the string
        if (p.length() == 0) {
            return false;
        }

        //Next pattern grouping has wildcard
        if (p.length() > 1 && p.charAt(1) == '*') {
            for (int i = 0; i < s.length(); i++) {
                //Wildcard grouping requires specific character, e.g. a* requires a sequence of 0 or more 'a'
                //p.charAt(0) != '.' is required because that matches any character
                if (p.charAt(0) != '.' && s.charAt(i) != p.charAt(0)) {
                    break;
                }

                //Consume i characters from string and grouping from pattern
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
            }
            //Consume the pattern as in 0 matches for that wildcard pattern
            return isMatch(s, p.substring(2));
        }

        if (p.charAt(0) == '.') {
            //Consume the '.' pattern, any single-char. The .* pattern is handled around line 16-30, more specifically 20-22
            return s.length() > 0 && isMatch(s.substring(1), p.substring(1));
        }

        //Simple single-char match
        if (s.length() > 0 && s.charAt(0) == p.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        }

        //No wildcards or single-char match
        return false;
    }
}
