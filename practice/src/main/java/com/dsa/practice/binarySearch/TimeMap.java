package com.dsa.practice.binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    /**
     *  The key to solving this problem efficiently is to 
     * use a combination of HashMap and TreeMap. HashMap stores
     * the key and its corresponding TreeMap as value. The TreeMap
     * stores timestamps as keys and their corresponding value 
     * as values. TreeMap is used because it maintains the order of keys,
     * which allows us to efficiently retrieve the largest timestamp
     */
    
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if( treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
    
}