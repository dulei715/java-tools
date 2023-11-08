package cn.edu.ecnu.basic;



import cn.edu.ecnu.DecimalTool;
import cn.edu.ecnu.struct.pair.BasicPair;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

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


    public static double getLinearTransformValue(double oldLeftPoint, double oldRightPoint, double oldValue, double newLeftPoint, double newRightPoint) {
        return newLeftPoint + (newRightPoint - newLeftPoint) / (oldRightPoint - oldLeftPoint) * (oldValue - oldLeftPoint);
    }

    public static void fillLinearTransformValue(double leftValue, double rightValue, double[] toBeFilledArray, int leftIndex, int rightIndex, boolean whetherContainLeftValueAndRightValue) {
        int indexDiffer= rightIndex - leftIndex;
        if (indexDiffer < 0 || indexDiffer < 1 && whetherContainLeftValueAndRightValue) {
            throw new RuntimeException("The difference between rightIndex and leftIndex is illegal!");
        }
        int from, end, stepAddition;
        double step, tempValue;
        if (whetherContainLeftValueAndRightValue) {
            toBeFilledArray[leftIndex] = leftValue;
            toBeFilledArray[rightIndex] = rightValue;
            from = leftIndex + 1;
            end = rightIndex - 1;
            stepAddition = 0;
        } else {
            from = leftIndex;
            end = rightIndex;
            stepAddition = 2;
        }
        step = (rightValue - leftValue) / (rightIndex - leftIndex + stepAddition);
        tempValue = leftValue + step;
        for (int index = from; index <= end; index++) {
            toBeFilledArray[index] = tempValue;
            tempValue += step;
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

    public static Double[] getLogTransform(Double[] element, double factorA, double constC) {
        Double[] result = new Double[element.length];
        for (int i = 0; i < element.length; i++) {
            result[i] = Math.log(element[i]) * factorA + constC;
        }
        return result;
    }

    public static Double[][] getLinearTransform(Double[][] element, double factorA, double constC) {
        Double[][] result = new Double[element.length][element[0].length];
        for (int i = 0; i < element.length; i++) {
            for (int j = 0; j < element[0].length; j++) {
                result[i][j] = element[i][j] * factorA + constC;
            }
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
    public static Double[] getLinearTransformFromIntegerList(List<Integer> element, double factorA, double constC) {
        Double[] result = new Double[element.size()];
        for (int i = 0; i < element.size(); i++) {
            result[i] = element.get(i) * factorA + constC;
        }
        return result;
    }
    public static Double[] getLinearTransformFromIntegerArray(Integer[] elementArray, double factorA, double constC) {
        Double[] result = new Double[elementArray.length];
        for (int i = 0; i < elementArray.length; i++) {
            result[i] = elementArray[i] * factorA + constC;
        }
        return result;
    }


    /**
     * 初始化数组每个值为一个集合。该集合不能是抽象类或接口
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

    public static double[] toDouArray(Collection<Double> data) {
        double[] result = new double[data.size()];
        Iterator<Double> iterator = data.iterator();
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next();
        }
        return result;
    }


    /**
     * 每个数组元素引用同一个元素
     * @param value
     * @param size
     * @return
     * @param <T>
     */
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

    /**
     * 每个list元素引用不同的元素
     * @param value
     * @param size
     * @return
     * @param <T>
     */
    public static <T> List<T> getInitializedList(T value, int size) throws InstantiationException, IllegalAccessException {
        Class clazz = value.getClass();
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add((T) clazz.newInstance());
        }
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

    public static double[] getIncreasedoubleNumberArray(double startValue, double step, double maxValue, int precision) {
        int size = (int) Math.ceil((maxValue - startValue) / step + 1);
        double[] result = new double[size];
        double value;
        int i;
        for (value = startValue, i = 0; value <= maxValue; value += step, i++) {
            result[i] = DecimalTool.round(value, precision);
        }
        if (i < size) {
            result[i] = DecimalTool.round(maxValue, precision);
        }
        return result;
    }

    public static Double[] getIncreaseDoubleNumberArray(double startValue, double step, double maxValue) {
        int size = (int) Math.ceil((maxValue - startValue) / step + 1);
        Double[] result = new Double[size];
        double value;
        int i;
        for (value = startValue, i = 0; value <= maxValue; value += step, i++) {
            result[i] = value;
        }
        if (i < size) {
            result[i] = maxValue;
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

    public static Double[] extractSubArrayInGivenIndexList(Double[] data, List<Integer> indexList) {
        Double[] result = new Double[indexList.size()];
        int k = 0;
        for (Integer tempIndex : indexList) {
            result[k++] = data[tempIndex];
        }
        return result;
    }
    public static double[] extractSubArrayInGivenIndexList(double[] data, List<Integer> indexList) {
        double[] result = new double[indexList.size()];
        int k = 0;
        for (int tempIndex : indexList) {
            result[k++] = data[tempIndex];
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


    public static <T extends Comparable<T>> BasicPair<Integer, T> getMaxValuePair(T... objs) {
        T result = objs[0];
        Integer index = 0;
        for (int i = 1; i < objs.length; i++) {
            if (result.compareTo(objs[i]) < 0) {
                index = i;
                result = objs[i];
            }
        }
        return new BasicPair<>(index, result);
    }

    public static <T extends Comparable<T>> BasicPair<Integer, T> getMinValuePair(T... objs) {
        T result = objs[0];
        Integer index = 0;
        for (int i = 1; i < objs.length; i++) {
            if (result.compareTo(objs[i]) > 0) {
                index = i;
                result = objs[i];
            }
        }
        return new BasicPair<>(index, result);
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



    /**
     * 将两个数组合并成一个列表
     * @param arrA
     * @param arrB
     * @return
     */
    public static List<Integer> getCombinedListOfTwoIntegerArray(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>(arrA.length + arrB.length);
        for (int i = 0; i < arrA.length; i++) {
            list.add(arrA[i]);
        }
        for (int i = 0; i < arrB.length; i++) {
            list.add(arrB[i]);
        }
        return list;
    }


    public static Double getSumFromGivenIndexSets(List<List<Double>> numberList, Integer rowIndex, Collection<Integer> colIndexSet) {
        Double sum = 0.0;
        if (colIndexSet == null) {
            return sum;
        }
        List<Double> chosenList;
        chosenList = numberList.get(rowIndex);
        for (Integer yIndex : colIndexSet) {
            sum += chosenList.get(yIndex);
        }
        return sum;
    }

    public static Double getSumFromGivenIndexSets(List<List<Double>> numberList, Collection<Integer> rowIndexSet, Integer colIndex) {
        Double sum = 0.0;
        if (rowIndexSet == null) {
            return sum;
        }
        for (Integer xIndex : rowIndexSet) {
            sum += numberList.get(xIndex).get(colIndex);
        }
        return sum;
    }

    public static void setArrayToDeclaredValueByIndexList(int[] arr, List<Integer> indexList, int value) {
        for (Integer index : indexList) {
            arr[index] = value;
        }
    }

    public static int getIndexOfMinimalValueGreaterThanDeclaredValue(List<Integer> data, Integer value) {
        Integer minimalValue = Integer.MAX_VALUE;
        int index = -1;
        Integer tempValue;
        for (int i = 0; i < data.size(); i++) {
            tempValue = data.get(i);
            if (tempValue > value && tempValue < minimalValue) {
                minimalValue = tempValue;
                index = i;
            }
        }
        return index;
    }


    public static List<Integer> getIndexListWithValueGreaterThanDeclaredValue(Double[] data, Integer value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] > value) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> getIndexListWithValueGreaterThanDeclaredValue(double[] data, Integer value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] > value) {
                result.add(i);
            }
        }
        return result;
    }

}
