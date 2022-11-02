package com.interview.sde.java.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/subdomain-visit-count/
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainAccessCount = new HashMap<>();

        for (String domain : cpdomains) {
            //extract the full domain
            int index = domain.indexOf(' ') + 1;

            //extract the number, which will always be before the whitespace
            int count = Integer.parseInt(domain.substring(0, index - 1));

            do {
                //update the domain count
                domainAccessCount.compute(domain.substring(index), (k, v) -> v == null ? count : count + v);
                //extract the subdomain inside a loop
                index = domain.indexOf('.', index + 1) + 1;
                //if index > 0, we have at least one subdomain remaining to be processed
            } while (index > 0);
        }

        return domainAccessCount.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }
}
