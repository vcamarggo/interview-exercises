package com.interview.sde.java.datastructure;

import java.util.*;

public class LFUCache {

    private final int capacity;
    private final Map<Integer, Integer> keyToUsageMapping;
    private final TreeMap<Integer, List<Integer>> usageToKeysMapping;
    private final Map<Integer, Integer> dataStore;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToUsageMapping = new HashMap<>();
        this.usageToKeysMapping = new TreeMap<>();
        this.dataStore = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!isValidCapacity() || !dataStore.containsKey(key)) return -1;
        int value = dataStore.get(key);
        updateExistingKey(key, value);
        return value;
    }

    private boolean isValidCapacity() {
        return capacity > 0;
    }

    public void put(int key, int value) {
        if (isValidCapacity()) {
            if (dataStore.containsKey(key)) {
                updateExistingKey(key, value);
            } else if (dataStoreHasFreeCapacity()) {
                addNewKey(key, value);
            } else {
                removeKeyUsingLFUThenLRUIfTied();
                addNewKey(key, value);

            }
        }
    }

    private void removeKeyUsingLFUThenLRUIfTied() {
        Map.Entry<Integer, List<Integer>> leastUsedKeys = usageToKeysMapping.firstEntry();
        List<Integer> leastUsedKeysList = leastUsedKeys.getValue();

        Integer keyToRemove = getKeyToRemove(leastUsedKeysList);

        //No need to removeEmptyKey because the new key would be either removed because it is used first,
        // or it would be used up to the current least used key,
        // which would not be empty or be deleted if the key was used more than the current least used
        usageToKeysMapping.computeIfAbsent(leastUsedKeys.getKey(), k -> new ArrayList<>()).remove(keyToRemove);
        keyToUsageMapping.remove(keyToRemove);
        dataStore.remove(keyToRemove);
    }

    private void addNewKey(int key, int value) {
        //new key always have counter 1
        keyToUsageMapping.compute(key, (k, v) -> 1);
        usageToKeysMapping.computeIfAbsent(1, k -> new ArrayList<>()).add(key);
        updateDataStore(key, value);
    }

    private Integer getKeyToRemove(List<Integer> leastUsedNumbers) {
        //The first key contained in the leastUsedNumbers means that it was added the earlist among the leastUsedNumbers
        for (Integer keyIt : dataStore.keySet()) {
            if (leastUsedNumbers.contains(keyIt)) {
                return keyIt;
            }
        }
        return null;
    }

    private boolean dataStoreHasFreeCapacity() {
        return dataStore.size() < capacity;
    }

    private void updateExistingKey(int key, int value) {
        int usage = keyToUsageMapping.compute(key, (k, v) -> v + 1);

        usageToKeysMapping.computeIfAbsent(usage - 1, k -> new ArrayList<>()).remove(Integer.valueOf(key));
        usageToKeysMapping.computeIfAbsent(usage, k -> new ArrayList<>()).add(key);

        //Remove empty keys
        removeEmptyKey(usage - 1);

        updateDataStore(key, value);
    }

    private void updateDataStore(int key, int value) {
        dataStore.remove(key);
        dataStore.put(key, value);
    }

    private void removeEmptyKey(int key) {
        if (usageToKeysMapping.get(key).isEmpty()) {
            usageToKeysMapping.remove(key);
        }
    }


}