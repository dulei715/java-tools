package cn.edu.dll.struct.pair;


import java.util.Objects;

public class PurePair<K, V> {
    protected K key;
    protected V value;
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public PurePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.key + "=" + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurePair<?, ?> basicPair = (PurePair<?, ?>) o;
        return Objects.equals(key, basicPair.key) &&
                Objects.equals(value, basicPair.value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }



}
