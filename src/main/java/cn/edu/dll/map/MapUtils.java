package cn.edu.dll.map;

import java.util.*;

public class MapUtils {


    public static <K, V> void putInListValue(Map<K, List<V>> map, K key, V value) {
        List<V> valueList = map.get(key);
        if (valueList == null) {
            valueList = new ArrayList<>();
            map.put(key, valueList);
        }
        valueList.add(value);
    }
    public static <K, V> void putInSetValue(Map<K, Set<V>> map, K key, V value) {
        Set<V> valueSet = map.get(key);
        if (valueSet == null) {
            valueSet = new HashSet<>();
            map.put(key, valueSet);
        }
        valueSet.add(value);
    }

    public static <K, P, V> void addMapAsValue(Map<K, Map<P, Set<V>>> rawMap, K rawKey, P innerKey, V value) {
        Map<P, Set<V>> innerMap = rawMap.get(rawKey);
        if (innerMap == null) {
            innerMap = new HashMap<>();
            rawMap.put(rawKey, innerMap);
        }
        putInSetValue(innerMap, innerKey, value);
    }

    public static <T extends Comparable<T>> TreeMap<T, List<Integer>> getSortResult(T[] statisticValueArray, List<Integer> regionIndex) {
        TreeMap<T, List<Integer>> orderMap = new TreeMap<>();
        T tempValue;
        int tempIndex;
        List<Integer> tempList;
        for (int i = 0; i < regionIndex.size(); i++) {
            tempIndex = regionIndex.get(i);
            tempValue = statisticValueArray[tempIndex];
            if (orderMap.containsKey(tempValue)) {
                tempList = orderMap.get(tempValue);
                tempList.add(tempIndex);
            } else {
                tempList = new ArrayList<>();
                tempList.add(tempIndex);
                orderMap.put(tempValue, tempList);
            }
        }
        return orderMap;
    }
    public static <T extends Comparable<T>> TreeMap<T, List<Integer>> getSortResult(TreeMap<Integer, T> statisticValueMap, List<Integer> regionIndex) {
        TreeMap<T, List<Integer>> orderMap = new TreeMap<>();
        T tempValue;
        int tempIndex;
        List<Integer> tempList;
        for (int i = 0; i < regionIndex.size(); i++) {
            tempIndex = regionIndex.get(i);
            tempValue = statisticValueMap.get(tempIndex);
            if (orderMap.containsKey(tempValue)) {
                tempList = orderMap.get(tempValue);
                tempList.add(tempIndex);
            } else {
                tempList = new ArrayList<>();
                tempList.add(tempIndex);
                orderMap.put(tempValue, tempList);
            }
        }
        return orderMap;
    }

    public static <T> Double getValueSum(TreeMap<T, Double> data) {
        Collection<Double> valueCollection = data.values();
        Double result = 0D;
        for (Double value : valueCollection) {
            result += value;
        }
        return result;
    }

    public static <T> Integer getIntegerValueSum(TreeMap<T, Integer> data) {
        Collection<Integer> valueCollection = data.values();
        Integer result = 0;
        for (Integer value : valueCollection) {
            result += value;
        }
        return result;
    }

}
