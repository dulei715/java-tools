package cn.edu.ecnu.collection;

import java.lang.reflect.Array;
import java.util.*;

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

    public static <T> T getElementByIndex(TreeSet<T> elementSet, int index) {
        Iterator<T> iterator = elementSet.iterator();
        T tempElement = null;
        for (int i = 0; i <= index; i++) {
            tempElement = iterator.next();
        }
        return tempElement;
    }

    public static <T> TreeSet<T> getResidualOrderedElement(final List<T> originalList, Collection<T> removeCollection) {
        TreeSet<T> treeSet = new TreeSet<>(originalList);
        treeSet.removeAll(removeCollection);
        return treeSet;

    }

}
