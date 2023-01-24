package cn.edu.ecnu.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtils {
    public static <K, V> void put(Map<K, Set<V>> map, K key, V value) {
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
        put(innerMap, innerKey, value);
    }
}
