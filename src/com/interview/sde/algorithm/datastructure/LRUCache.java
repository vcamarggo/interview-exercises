package com.interview.sde.algorithm.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    private Map<Integer, Integer> data = new LinkedHashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            int value = data.remove(key);
            data.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else if (data.size() == capacity) {
            data.remove(data.keySet().iterator().next());
        }

        data.put(key, value);
    }

/*
  Your LRUCache object will be instantiated and called as such:
  LRUCache obj = new LRUCache(capacity);
  int param_1 = obj.get(key);
  obj.put(key,value);
 */
}
