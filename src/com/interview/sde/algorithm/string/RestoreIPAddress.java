package com.interview.sde.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {
            return Collections.emptyList();
        }
        return restoreIpAddresses(s, 0, -1);
    }

    public List<String> restoreIpAddresses(String s, int separators, int lastSeparatorIndex) {
        List<String> solution = new ArrayList<>();
        if (separators == 3) {
            if (isValidSubIPV4(s, lastSeparatorIndex, s.length()))
                solution.add(s);
            return solution;
        }


        for (int i = lastSeparatorIndex + 1; i <= lastSeparatorIndex + 3 && i + 1 < s.length(); i++) {
            int newIndex = i + 1;
            if (isValidSubIPV4(s, lastSeparatorIndex, newIndex)) {
                solution.addAll(restoreIpAddresses(new StringBuilder(s).insert(newIndex, '.').toString(), separators + 1, newIndex));
            }
        }

        return solution;
    }

    private boolean isValidSubIPV4(String s, int lastSeparatorIndex, int newSeparatorIndex) {
        if (newSeparatorIndex > s.length())
            return false;
        String octet = s.substring(lastSeparatorIndex + 1, newSeparatorIndex);
        int octetInt = Integer.parseInt(octet);
        return (octet.charAt(0) == '0' && octet.length() == 1) || (octet.charAt(0) != '0' && octetInt > 0 && octetInt <= 255);
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddress().restoreIpAddresses("0279245587303"));
        System.out.println(new RestoreIPAddress().restoreIpAddresses("25525511135"));
        System.out.println(new RestoreIPAddress().restoreIpAddresses("0000"));
        System.out.println(new RestoreIPAddress().restoreIpAddresses("101023"));
    }
}
