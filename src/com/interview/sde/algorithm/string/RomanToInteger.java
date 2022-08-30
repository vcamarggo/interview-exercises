package com.interview.sde.algorithm.string;

//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    public int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            //I or II or III or IV or IX
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1) {
                    //II or III
                    if (s.charAt(i + 1) == 'I') {
                        //III
                        if (i < s.length() - 2 && s.charAt(i + 2) == 'I') {
                            number += 1;
                            i++;
                        }
                        number += 1;
                        i++;
                        //IV
                    } else if (s.charAt(i + 1) == 'V') {
                        number += 3;
                        i++;
                        //IX
                    } else if (s.charAt(i + 1) == 'X') {
                        number += 8;
                        i++;
                    }
                }
                number += 1;
                //X or XX or XXX or XL or XC
            } else if (s.charAt(i) == 'X') {
                if (i < s.length() - 1) {
                    //XX or XXX
                    if (s.charAt(i + 1) == 'X') {
                        //XXX
                        if (i < s.length() - 2 && s.charAt(i + 2) == 'X') {
                            number += 10;
                            i++;
                        }
                        number += 10;
                        i++;
                        //XL
                    } else if (s.charAt(i + 1) == 'L') {
                        number += 30;
                        i++;
                        //XC
                    } else if (s.charAt(i + 1) == 'C') {
                        number += 80;
                        i++;
                    }
                }
                number += 10;
                //C or CC or CCC or CD or CM
            } else if (s.charAt(i) == 'C') {
                if (i < s.length() - 1) {
                    //CC or CCC
                    if (s.charAt(i + 1) == 'C') {
                        if (i < s.length() - 2 && s.charAt(i + 2) == 'C') {
                            number += 100;
                            i++;
                        }
                        number += 100;
                        i++;
                        //CD
                    } else if (s.charAt(i + 1) == 'D') {
                        number += 300;
                        i++;
                        //CM
                    } else if (s.charAt(i + 1) == 'M') {
                        number += 800;
                        i++;
                    }
                }
                number += 100;
                //V, but not IV
            } else if (s.charAt(i) == 'V') {
                number += 5;
                //L, but not XL
            } else if (s.charAt(i) == 'L') {
                number += 50;
                //D, but not CD
            } else if (s.charAt(i) == 'D') {
                number += 500;
                //M, but not CM
            } else if (s.charAt(i) == 'M') {
                number += 1000;
            }
        }
        return number;
    }
}
