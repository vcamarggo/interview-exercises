package com.interview.sde.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/simple-bank-system/
public class SimpleBankSystem {
    private final Map<Integer, Long> accounts;

    public SimpleBankSystem(long[] balances) {
        accounts = new HashMap<>();
        int ID = 1;
        for(Long balance : balances){
            accounts.put(ID++, balance);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if(isAccountValid(account1) && isAccountValid(account2)){
            long accountBalance1 = accounts.get(account1);
            if(money <= accountBalance1){
                accounts.put(account1, accountBalance1-money);
                // the reason to fetching the account2 right before the transfer is that acc1 and acc2 might be equal
                long accountBalance2 = accounts.get(account2);
                accounts.put(account2, accountBalance2+money);
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(isAccountValid(account)){
            long accountBalance = accounts.get(account);
            accounts.put(account, accountBalance+money);
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(isAccountValid(account)){
            long accountBalance = accounts.get(account);
            if(money <= accountBalance){
                accounts.put(account, accountBalance-money);
                return true;
            }
        }
        return false;
    }

    public boolean isAccountValid(int account){
        return accounts.containsKey(account);
    }
}
