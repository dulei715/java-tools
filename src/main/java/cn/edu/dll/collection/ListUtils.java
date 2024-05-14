package cn.edu.dll.collection;

import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.differential_privacy.cdp.basic_struct.DistanceAble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListUtils {

    public static <T> List<T> valueOf(T... arr) {
        List<T> resultList = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            resultList.add(arr[i]);
        }
        return resultList;
    }

    public static <T> List<T> valueOf(Collection<T> collection) {
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            result.add(t);
        }
        return result;
    }

    public static <T> List<List<T>> generateTwoDimensionalList(T defaultValue, int rowSize, int colSize) {
        List<List<T>> list = new ArrayList<>();
        List<T> tempList;
        for (int i = 0; i < rowSize; i++) {
            tempList = new ArrayList<>();
            for (int j = 0; j < colSize; j++) {
                tempList.add(defaultValue);
            }
            list.add(tempList);
        }
        return list;
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
        T[] resultArray = BasicArrayUtil.copyToArrayGivenElement(element, size);
        return Arrays.asList(resultArray);
    }

    public static <T> List<T> subList(List<T> originalList, int fromIndex, int endIndex) {
        List<T> list = new ArrayList<>(endIndex - fromIndex + 1);
        for (int i = fromIndex; i <= endIndex; i++) {
             list.add(originalList.get(i));
        }
        return list;
    }

    public static <T> List<T> subList(List<T> originalList, List<Integer> indexList) {
        List<T> list = new ArrayList<>(indexList.size());
        for (Integer i : indexList) {
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

    public static <T> List<List<T>> toMatrixList(T[][] data) {
        List<List<T>> result = new ArrayList<>();
        List<T> tempList;
        for (int i = 0; i < data.length; i++) {
            tempList = new ArrayList<>();
            for (int j = 0; j < data[i].length; j++) {
                tempList.add(data[i][j]);
            }
            result.add(tempList);
        }
        return result;
    }

    public static double getMinimalValue(List<Double> data) {
        double result = Double.MAX_VALUE;
        for (Double element : data) {
            if (element < result) {
                result = element;
            }
        }
        return result;
    }
    public static double getMaximalValue(List<Double> data, Double minimalLowerBound) {
        double result = minimalLowerBound;
        for (Double element : data) {
            if (element > result) {
                result = element;
            }
        }
        return result;
    }

    public static <T> void addValue(List<T> list, T element, int size) {
        for (int i = 0; i < size; i++) {
            list.add(element);
        }
    }

    public static <T> List<T> generateListWithFixedElement(T element, int size) {
        List<T> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(element);
        }
        return result;
    }

}
