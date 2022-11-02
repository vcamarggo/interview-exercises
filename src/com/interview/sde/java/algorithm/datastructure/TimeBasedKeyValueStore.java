package com.interview.sde.algorithm.datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/time-based-key-value-store/
public class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> timemap;

    public TimeBasedKeyValueStore() {
        timemap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timemap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeValues = timemap.getOrDefault(key, new TreeMap<>());
        Map.Entry<Integer, String> entry = timeValues.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore store = new TimeBasedKeyValueStore();
        store.set("foo", "bar", 1);
        System.out.println(store.get("foo",1));
        System.out.println(store.get("foo",3));
        store.set("foo", "bar2", 4);
        System.out.println(store.get("foo",4));
        System.out.println(store.get("foo",5));
    }
}
