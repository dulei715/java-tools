package cn.edu.ecnu.basic;


import javafx.util.Pair;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
public class BasicArray {
    public static void setIntArrayTo(int[] element, int value) {
        for (int i = 0; i < element.length; i++) {
            element[i] = value;
        }
    }

    public static void setIntArrayTo(Integer[] element, int value) {
        for (int i = 0; i < element.length; i++) {
            element[i] = value;
        }
    }

    public static void setIntArrayToZero(int[] element) {
        setIntArrayTo(element, 0);
    }

    public static void setIntArrayToZero(Integer[] element) {
        setIntArrayTo(element, 0);
    }

    public static void setIntArrayTo(Integer[][] element, int value) {
        for (int i = 0; i < element.length; i++) {
            for (int j = 0; j < element[0].length; j++) {
                element[i][j] = value;
            }
        }
    }

    public static void setDoubleArrayTo(double[] element, double value) {
        for (int i = 0; i < element.length; i++) {
            element[i] = value;
        }
    }

    public static void setDoubleArrayTo(double[][] element, double value) {
        for (int i = 0; i < element.length; i++) {
            for (int j = 0; j < element[0].length; j++) {
                element[i][j] = value;
            }
        }
    }

    public static void setDoubleArrayTo(Double[] element, double value) {
        for (int i = 0; i < element.length; i++) {
            element[i] = value;
        }
    }

    public static void setDoubleArrayTo(Double[][] element, double value) {
        for (int i = 0; i < element.length; i++) {
            for (int j = 0; j < element[0].length; j++) {
                element[i][j] = value;
            }
        }
    }


    public static void linearTransform(double[] element, double factorA, double constC) {
        for (int i = 0; i < element.length; i++) {
            element[i] = element[i] * factorA + constC;
        }
    }

    public static void linearTransform(Double[] element, double factorA, double constC) {
        for (int i = 0; i < element.length; i++) {
            element[i] = element[i] * factorA + constC;
        }
    }

    public static double[] getLinearTransform(double[] element, double factorA, double constC) {
        double[] result = new double[element.length];
        for (int i = 0; i < element.length; i++) {
            result[i] = element[i] * factorA + constC;
        }
        return result;
    }

    public static Double[] getLinearTransform(Double[] element, double factorA, double constC) {
        Double[] result = new Double[element.length];
        for (int i = 0; i < element.length; i++) {
            result[i] = element[i] * factorA + constC;
        }
        return result;
    }
    public static Double[] getLinearTransform(List<Double> element, double factorA, double constC) {
        Double[] result = new Double[element.size()];
        for (int i = 0; i < element.size(); i++) {
            result[i] = element.get(i) * factorA + constC;
        }
        return result;
    }

//    public static void setListArrayToEmptyList(List[] element) {
//        for (int i = 0; i < element.length; i++) {
//            element[i] = new ArrayList();
//        }
//    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     * @param collectionArray
     * @param clazz
     * @param <T>
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T extends Collection> void setToEmptyGroup(T[]  collectionArray, Class<T> clazz) throws IllegalAccessException, InstantiationException {

        for (int i = 0; i < collectionArray.length; i++) {
            collectionArray[i] = clazz.newInstance();
        }
    }

    public static <T extends Map> void setToEmptyGroup(T[]  mapArray, Class<T> clazz) throws IllegalAccessException, InstantiationException {

        for (int i = 0; i < mapArray.length; i++) {
            mapArray[i] = clazz.newInstance();
        }
    }


//    public static void setListArrayTo(List[] element, List list) {
//        for (int i = 0; i < element.length; i++) {
//            element[i] = new ArrayList(list);
//        }
//    }

    public static <T extends Collection> void setGroupArrayTo(T[] elementArray, T initCollection, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = clazz.getConstructor(Collection.class);
        for (int i = 0; i < elementArray.length; i++) {
            elementArray[i] = constructor.newInstance(initCollection);
        }
    }

    public static <T extends Map> void setGroupArrayTo(T[] elementArray, T initMap, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = clazz.getConstructor(Map.class);
        for (int i = 0; i < elementArray.length; i++) {
            elementArray[i] = constructor.newInstance(initMap);
        }
    }

    public static void setIntegerListToContinuousNaturalNumber(List<Integer> list, Integer maxNaturalNumber) {
        for (int i = 0; i <= maxNaturalNumber; i++) {
            list.add(i);
        }
    }

    public static void setDoubleArrayToZero(double[] element) {
        setDoubleArrayTo(element, 0.0);
    }

    public static void setDoubleArrayToZero(double[][] element) {
        setDoubleArrayTo(element, 0.0);
    }

    public static void setDoubleArrayToZero(Double[] element) {
        setDoubleArrayTo(element, 0.0);
    }

    public static void setDoubleArrayToZero(Double[][] element) {
        setDoubleArrayTo(element, 0.0);
    }


    public static Integer[] toIntegerArray(String[] arr) {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.valueOf(arr[i]);
        }
        return result;
    }


    public static int[] toIntArray(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }

    public static Double[] toDoubleArray(String[] arr) {
        Double[] result = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Double.valueOf(arr[i]);
        }
        return result;
    }

    public static double[] toDouArray(String[] arr) {
        double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Double.parseDouble(arr[i]);
        }
        return result;
    }


    public static <T> T[] getInitializedArray(T value, int size) {
        Class clazz = value.getClass();
        Object array = null;
        array = Array.newInstance(clazz, size);
        for (int i = 0; i < size; i++) {
            Array.set(array, i, value);
        }
        T[] result = (T[]) array;
        return result;
    }

    public static Integer[] getIncreaseIntegerNumberArray(Integer startValue, int step, Integer maxValue) {
        int size = (maxValue - startValue) / step + 1;
        Integer[] result = new Integer[size];
        for (int value = startValue, i = 0; value <= maxValue; value += step, i++) {
            result[i] = value;
        }
        return result;
    }

    public static List<Integer> getIncreaseIntegerNumberList(Integer startValue, int step, Integer maxValue) {
        int size = (maxValue - startValue) / step + 1;
        List<Integer> result = new ArrayList<>(size);
        for (int value = startValue; value <= maxValue; value += step) {
            result.add(value);
        }
        return result;
    }


    public static int getFirstFindValueIndex(int[] data, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> getDeclaredValueIndexList(int[] data, int value) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static <T> List<T> getElementListInGivenIndexes(List<T> elementList, List<Integer> indexList) {
        List<T> result = new ArrayList<>(indexList.size());
        for (Integer index : indexList) {
            result.add(elementList.get(index));
        }
        return result;
    }

    public static <T> int getFirstFindValueIndex(T[] data, T value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int getFirstFindValueIndexByGivenColum(T[][] data, int colum, T value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i][colum].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int getFirstFindValueIndex(List<T> data, T value) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }


    public static <T extends Comparable<T>> Pair<Integer, T> getMaxValuePair(T... objs) {
        T result = objs[0];
        Integer index = 0;
        for (int i = 1; i < objs.length; i++) {
            if (result.compareTo(objs[i]) < 0) {
                index = i;
                result = objs[i];
            }
        }
        return new Pair<>(index, result);
    }

    public static <T extends Comparable<T>> Pair<Integer, T> getMinValuePair(T... objs) {
        T result = objs[0];
        Integer index = 0;
        for (int i = 1; i < objs.length; i++) {
            if (result.compareTo(objs[i]) > 0) {
                index = i;
                result = objs[i];
            }
        }
        return new Pair<>(index, result);
    }

    public static Integer getSum(Integer... nums) {
        Integer sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static Double getSum(Double... nums) {
        Double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }


}
