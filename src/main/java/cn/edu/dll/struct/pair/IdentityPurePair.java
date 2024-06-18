package cn.edu.dll.struct.pair;

import java.util.ArrayList;
import java.util.List;

public class IdentityPurePair<T> extends PurePair<T, T>{
    /**
     * Creates a new pair
     *
     * @param key   The key for this pair
     * @param value The value to use for this pair
     */
    public IdentityPurePair(T key, T value) {
        super(key, value);
    }
    public void exchangeKeyValue() {
        T temp = this.getKey();
        this.key = this.value;
        this.value = temp;
    }
    public List<T> toList() {
        List<T> result = new ArrayList<>(2);
        result.add(this.key);
        result.add(this.value);
        return result;
    }
}
