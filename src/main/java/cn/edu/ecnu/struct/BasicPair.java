package cn.edu.ecnu.struct;

import javafx.util.Pair;

public class BasicPair<K extends Comparable<K>, V extends Comparable<V>> extends Pair<K,V> implements Comparable<BasicPair> {
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public BasicPair(K key, V value) {
        super(key, value);
    }

    @Override
    public int compareTo(BasicPair basicPair) {
        int keyCompare = this.getKey().compareTo((K)basicPair.getKey());
        if (keyCompare != 0) {
            return keyCompare;
        }
        return this.getValue().compareTo((V)basicPair.getValue());
    }

}
