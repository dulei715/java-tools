package cn.edu.dll.struct.vector;

import cn.edu.dll.basic.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BinaryVector {
    public static final Boolean ZERO = false;
    public static final Boolean ONE = true;
    protected List<Boolean> data;

    public BinaryVector(Collection<Boolean> data) {
        this.data = new ArrayList<>(data);
    }

    public BinaryVector(Boolean... data) {
        this.data = new ArrayList<>(data.length);
        for (Boolean datum : data) {
            this.data.add(datum);
        }
    }

    public BinaryVector(boolean... data) {
        this.data = new ArrayList<>(data.length);
        for (Boolean datum : data) {
            this.data.add(datum);
        }
    }


    public Boolean getBitValue(int index) {
        return this.data.get(index);
    }

    public void setBitValue(int index, Boolean value) {
        this.data.set(index, value);
    }

    public int getLength() {
        return this.data.size();
    }

    public void clear() {
        this.data.clear();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public Boolean[] toArray() {
        return this.data.toArray(new Boolean[0]);
    }

    @Override
    public String toString() {
        return StringUtil.join(", ", toArray());
    }

    public static void main(String[] args) {
        boolean[] data = new boolean[]{true, false, true};
        BinaryVector binaryVector = new BinaryVector(data);
        System.out.println(binaryVector);
    }
}
