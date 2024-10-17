package cn.edu.dll.struct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class OneHot {
    public static final boolean ONE = true;
    public static final boolean ZERO = false;
    private boolean[] data;

    public OneHot(int length) {
        this.data = new boolean[length];
    }

    public OneHot(int length, int position) {
        this(length);
        this.data[position] = true;
    }

//    public OneHot(boolean[] data) {
//        this.data = data;
//    }

    public OneHot(boolean... data) {
        this.data = data;
    }

    public int getDataLength() {
        return this.data.length;
    }

    public void setPosition(int position) {
        this.data[position] = true;
    }

    public void clearPosition(int position) {
        this.data[position] = false;
    }

    public boolean getValueByPosition(int position) {
        return this.data[position];
    }

    public boolean[] getData() {
        return this.data;
    }

    public String toOriginalString() {
        return Arrays.toString(data);
    }

    @Override
    public String toString() {
        String originalString =  Arrays.toString(data);
        return originalString.replaceAll("true", "1").replaceAll("false", "0");
    }
}
