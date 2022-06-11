package com.interview.sde.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-authentication-manager/
public class AuthenticationManager {
    private final Map<String, Integer> valid = new HashMap<>();
    final int ttl;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        valid.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (valid.containsKey(tokenId) && !isExpired(valid.get(tokenId), currentTime)) {
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int unexpired = 0;
        for(int expiration : valid.values()){
            unexpired += isExpired(expiration, currentTime) ? 0 : 1;
        }
        //Slower option
        //(int) valid.values().stream().filter(expiration -> !isExpired(expiration, currentTime)).count()
        return unexpired;
    }

    boolean isExpired(int expiration, int currentTime) {
        return expiration <= currentTime;
    }

}
