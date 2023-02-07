package cn.edu.ecnu.collection;

import cn.edu.ecnu.differential_privacy.cdp.basic_struct.DistanceAble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static <T> List<T> valueOf(T[] arr) {
        List<T> resultList = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            resultList.add(arr[i]);
        }
        return resultList;
    }

    public static Double sum(List<Double> list) {
        Double result = new Double(0);
        for (Double elem : list) {
            result += elem;
        }
        return result;
    }

    public static double getSum(List<double[]> list) {
        double result = 0;
        for (double[] doubles : list) {
            for (double dElem : doubles) {
                result += dElem;
            }
        }
        return result;
    }

    public static <T> void swap(List<T> elementList, int i, int j) {
        T tempElement = elementList.get(i);
        elementList.set(i, elementList.get(j));
        elementList.set(j, tempElement);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> elementList, int left, int right) {
        if (left > right) {
            return;
        }
        T baseElement = elementList.get(left);
        int i = left;
        int j = right;
        while (i < j) {
            while (elementList.get(j).compareTo(baseElement) >= 0 && i < j) {
                -- j;
            }
            while (elementList.get(i).compareTo(baseElement) <= 0 && i < j) {
                ++ i;
            }
            if (i < j) {
                swap(elementList, i, j);
            }
        }
        swap(elementList, left, i);
        quickSort(elementList, left, j - 1);
        quickSort(elementList, j + 1, right);
    }

    public static <T extends Comparable<T>> void quickSort(List<T> elementList) {
        int end = elementList.size() - 1;
        quickSort(elementList, 0, end);
    }

    public static <T> List<T> combine(List<T>[] listArray, int fromIndex, int endIndex) {
        List<T> list = new ArrayList<>();
        for (int i = fromIndex; i <= endIndex; i++) {
            if (listArray[i] == null) {
                continue;
            }
            list.addAll(listArray[i]);
        }
        return list;
    }

    /**
     * 将给定的element关联到生成了List中的每个元素
     * @param element
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<T> copyToListGivenElement(T element, int size) {
        T[] resultArray = ArraysUtils.copyToArrayGivenElement(element, size);
        return Arrays.asList(resultArray);
    }

    public static <T> List<T> subList(List<T> originalList, int fromIndex, int endIndex) {
        List<T> list = new ArrayList<>(endIndex - fromIndex + 1);
        for (int i = fromIndex; i <= endIndex; i++) {
             list.add(originalList.get(i));
        }
        return list;
    }

    public static <T extends DistanceAble<T>> Double getMinimalDistanceFromElementToList(Integer elementIndex, List<Integer> elementListIndexList, List<T> elementList) {
        Double resultDistance = Double.MAX_VALUE;
        Double tempDistance;
        T tempElement, element;
        element = elementList.get(elementIndex);
        for (Integer i : elementListIndexList) {
            tempElement = elementList.get(i);
            tempDistance = element.getDistance(tempElement);
            if (tempDistance < resultDistance) {
                resultDistance = tempDistance;
            }
        }
        return resultDistance;
    }



}
