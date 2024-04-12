package com.interview.sde.java.string;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses
public class NumUniqueEmails {
    public int numUniqueEmails(String[] emails) {

        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            String[] emailParts = email.split("@");
            String local = emailParts[0];
            String domain = emailParts[1];

            int fwdIndex = local.indexOf("+");
            if (fwdIndex > -1) {
                local = local.substring(0, fwdIndex);
            }
            local = local.replaceAll("\\.", "");
            unique.add(local + "@" + domain);
        }

        return unique.size();

    }
}
