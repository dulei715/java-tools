package cn.edu.ecnu.collection;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Set;

public class SetUtils {
    public static <T> T[] toArray(Set<T> elementSet, Class<T> clazz) {

        T[] arr = (T[])Array.newInstance(clazz, elementSet.size());
        Iterator<T> iterator = elementSet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Array.set(arr, index, iterator.next());
            ++index;
        }
        return arr;
    }
}
