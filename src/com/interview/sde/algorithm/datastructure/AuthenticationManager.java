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

    public static void main(String[] args) {
//        AuthenticationManager am = new AuthenticationManager(5);
//        am.renew("aaa", 1);
//        am.generate("aaa", 2);
//        System.out.println(am.countUnexpiredTokens(6));//1
//        am.generate("bbb", 7);
//        am.renew("aaa", 8);
//        am.renew("bbb", 10);
//        System.out.println(am.countUnexpiredTokens(15));//0

//["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
//[[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]

//        AuthenticationManager am = new AuthenticationManager(6);
//        System.out.println(am.countUnexpiredTokens(5));//0
//        System.out.println(am.countUnexpiredTokens(6));//0
//        System.out.println(am.countUnexpiredTokens(7)); //0
//        am.generate("kxlq", 9);
//        am.renew("aaa", 10);
//        System.out.println(am.countUnexpiredTokens(15)); //0
//        am.renew("kxlq", 18);
//        am.generate("y", 19);
//        am.generate("r", 25);
//        am.generate("cmeix", 29);
//        am.generate("zfx", 30);

        AuthenticationManager am = new AuthenticationManager(13);
        am.renew("ajvy", 1);
        System.out.println(am.countUnexpiredTokens(3));//0
        System.out.println(am.countUnexpiredTokens(4));//0
        am.generate("fuzxq", 5);
        am.generate("izmry", 7);
        am.renew("puv", 12);
        am.generate("ybiqb", 13);
        am.generate("gm", 14);
        System.out.println(am.countUnexpiredTokens(15));//4
        System.out.println(am.countUnexpiredTokens(18));//3
        System.out.println(am.countUnexpiredTokens(19));//3
        am.renew("ybiqb", 21);
        System.out.println(am.countUnexpiredTokens(23));//2
        System.out.println(am.countUnexpiredTokens(25));//2
        System.out.println(am.countUnexpiredTokens(26));//2
        am.generate("aqdm", 28);
        System.out.println(am.countUnexpiredTokens(29));//2
        am.renew("puv", 30);

    }
}
