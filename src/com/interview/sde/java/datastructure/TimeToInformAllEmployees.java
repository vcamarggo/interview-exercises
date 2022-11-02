package com.interview.sde.java.datastructure;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/time-needed-to-inform-all-employees/
public class TimeToInformAllEmployees {
    static class ManagementChain {

        int id;
        int cost;
        List<ManagementChain> managees;

        public ManagementChain(int id, int cost) {
            this.id = id;
            this.cost = cost;
            this.managees = new ArrayList<>();
        }

    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // This could be a hashMap and query cost day form informTime
        // HashMap implementation was 3x slower on leetcode
        List<ManagementChain> company = new ArrayList<>(n);

        //Transform the input array into company data
        for (int i = 0; i < n; i++) {
            company.add(new ManagementChain(i, informTime[i]));
        }

        //Fill up the management chain
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                company.get(manager[i]).managees.add(company.get(i));
        }

        //Search the max cost starting from the head
        return getMaxInformTime(company.get(headID), 0);
    }

    public int getMaxInformTime(ManagementChain manager, int sumCost) {
        if (manager.cost == 0) {
            return sumCost;
        }

        int maxSumCost = 0;
        for (ManagementChain managee : manager.managees) {
            maxSumCost = Math.max(maxSumCost, getMaxInformTime(managee, sumCost + manager.cost));
        }

        return maxSumCost;
    }
}
