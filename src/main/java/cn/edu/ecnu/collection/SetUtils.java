package cn.edu.ecnu.collection;

import cn.edu.ecnu.basic.BasicArray;

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

//    public static <T extends Collection> T collectionMinus(T collectionA, T collectionB) throws InstantiationException, IllegalAccessException {
//        T resultCollection = (T) collectionA.getClass().newInstance();
//        resultCollection.addAll(collectionA);
//        Iterator iterator = resultCollection.iterator();
//        Object element;
//        while (iterator.hasNext()) {
//            element = iterator.next();
//            if (collectionB.contains(element)) {
//                iterator.remove();
//            }
//        }
//        return resultCollection;
//    }

    public static List<List<Integer>> getSubsetList(int n, int k, int beginInteger) {
        if (n < 0 || k < 0 || n < k) {
            throw new RuntimeException("Illegal parameters!");
        }
        List<List<Integer>> newListElement, tempElement;
        List<Integer> newCompElement;
        newListElement = new ArrayList<>();
        newListElement.add(new ArrayList<>());
        if (k == 0) {
            return newListElement;
        }
        List<List<List<Integer>>> resultList = new ArrayList<>();
        resultList.add(newListElement);
        List<List<List<Integer>>> beforeList;
        for (int i = 1; i <= n; i++) {
            beforeList = resultList;
            resultList = new ArrayList<>();
            newListElement = new ArrayList<>();
            newListElement.add(new ArrayList<>());
            resultList.add(newListElement);
            for (int j = 1; j <= Math.min(k, i); j++) {
                newListElement = new ArrayList<>();
                if (i > j) {
                    newListElement.addAll(beforeList.get(j));
                }
                tempElement = beforeList.get(j-1);
                for (List<Integer> compList : tempElement) {
                    newCompElement = new ArrayList<>(compList);
                    newCompElement.add(beginInteger + i - 1);
                    newListElement.add(newCompElement);
                }
                resultList.add(newListElement);
            }
        }
        return resultList.get(resultList.size()-1);

    }

    public static <T> List<List<T>> getSublistList(List<T> totalList, int sublistSize) {
        if (totalList == null || sublistSize < 0) {
            throw new RuntimeException("Illegal parameters!");
        }
        if (sublistSize > totalList.size()) {
            throw new RuntimeException("The given size is larger than the set size!");
        }
        int n = totalList.size();
        List<List<Integer>> subsetList = getSubsetList(n, sublistSize, 0);
        List<List<T>> resultList = new ArrayList<>();
        List<T> tempList;
        for (List<Integer> subsetElement : subsetList) {
            tempList = new ArrayList<>();
            for (Integer index : subsetElement) {
                tempList.add(totalList.get(index));
            }
            resultList.add(tempList);
        }
        return resultList;
    }
































}
