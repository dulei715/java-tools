package cn.edu.ecnu.collection;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

    public static <T> Set<T> combine(List<T>[] listArray, int fromIndex, int endIndex) {
        Set<T> set = new HashSet<>();
        for (int i = fromIndex; i <= endIndex; i++) {
            set.addAll(listArray[i]);
        }
        return set;
    }

}
