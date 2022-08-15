package cn.edu.ecnu.collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class ArraysUtils {
    /**
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return the minimal element whose value larger than key
     */
    public static int binaryDescendRangeSearchEqualRightFindLeft(double[] a, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = a[mid];

            if (midVal > key)
                low = mid + 1;  // Neither val is NaN, thisVal is smaller
            else if (midVal < key)
                high = mid - 1; // Neither val is NaN, thisVal is larger
            else {
                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits){
                    result =  mid - 1;             // Key found
                    if (result < 0) {
                        return -1;
                    }
                    return result;
                }else if (midBits > keyBits) // (-0.0, 0.0) or (!NaN, NaN)
                    low = mid + 1;
                else                        // (0.0, -0.0) or (NaN, !NaN)
                    high = mid - 1;
            }
        }
        result = low - 1;
        if (result < 0) {
            return -1;
        }
        return result;
    }

    public static int binaryDescendRangeSearchEqualRightFindLeft(double[] a, double key) {
        return binaryDescendRangeSearchEqualRightFindLeft(a, 0, a.length, key);
    }

    public static int binaryDescendRangeSearchEqualRightFindLeft(List<double[]> arrList, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double[] midVal = arrList.get(mid);

            if (midVal[0] > key)
                low = mid + 1;  // Neither val is NaN, thisVal is smaller
            else if (midVal[0] < key)
                high = mid - 1; // Neither val is NaN, thisVal is larger
            else {
                long midBits = Double.doubleToLongBits(midVal[0]);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits){
                    result =  mid - 1;             // Key found
                    if (result < 0) {
                        return -1;
                    }
                    return result;
                }else if (midBits > keyBits) // (-0.0, 0.0) or (!NaN, NaN)
                    low = mid + 1;
                else                        // (0.0, -0.0) or (NaN, !NaN)
                    high = mid - 1;
            }
        }
        result = low - 1;
        if (result < 0) {
            return -1;
        }
        return result;
    }

    public static int binaryDescendRangeSearchEqualRightFindLeft(List<double[]> arrList, double key) {
        return binaryDescendRangeSearchEqualRightFindLeft(arrList, 0, arrList.size(), key);
    }

    /**
     *
     * @param arrList
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return the minimal element whose value larger or equal than key
     */
    public static int binaryDescendRangeSearchEqualLeftFindLeft(List<double[]> arrList, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double[] midVal = arrList.get(mid);

            if (midVal[0] > key)
                low = mid + 1;  // Neither val is NaN, thisVal is smaller
            else if (midVal[0] < key)
                high = mid - 1; // Neither val is NaN, thisVal is larger
            else {
                long midBits = Double.doubleToLongBits(midVal[0]);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits){
                    return mid;
                }else if (midBits > keyBits) // (-0.0, 0.0) or (!NaN, NaN)
                    low = mid + 1;
                else                        // (0.0, -0.0) or (NaN, !NaN)
                    high = mid - 1;
            }
        }
        result = low - 1;
        if (result < 0) {
            return -1;
        }
        return result;
    }

    public static int binaryDescendRangeSearchEqualLeftFindLeft(List<double[]> arrList, double key) {
        return binaryDescendRangeSearchEqualLeftFindLeft(arrList, 0, arrList.size(), key);
    }

    public static int getDoubleMaxValue(List<Double> list) {
        int resultIndex = -1;
        double resultValue = Double.MIN_VALUE;
        double temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (resultValue < temp) {
                resultValue = temp;
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    public static int getDoubleArrayMaxValueByFirstValue(List<double[]> list) {
        int resultIndex = -1;
        double resultValue = Double.MIN_VALUE;
        double temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i)[0];
            if (resultValue < temp) {
                resultValue = temp;
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    public static <T> void shiftAndSet(T[][] inputArray, T[] outputArray) {
        int rowLen = inputArray.length;
        int colLen = inputArray[0].length;
        int outputSize = outputArray.length;
        if (rowLen * colLen != outputSize) {
            throw new RuntimeException("The quantity of inputArray is not equal to that of outputArray!");
        }
        int k = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                outputArray[k++] = inputArray[i][j];
            }
        }
    }

    public static <T> void reshapeAndSet(T[] inputArray, T[][] outputArray) {
        int rowLen = outputArray.length;
        int colLen = outputArray[0].length;
        int inputSize = inputArray.length;
        if (rowLen * colLen != inputSize) {
            throw new RuntimeException("The quantity of inputArray is not equal to that of outputArray!");
        }
        int k = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                 outputArray[i][j] = inputArray[k++];
            }
        }
    }

    /**
     * 将给定element引用在生成数组的每个元素上
     * @param element
     * @param size
     * @param <T>
     * @return
     */
    public static <T> T[] copyToArrayGivenElement(T element, int size) {
        T[] resultArray = (T[]) Array.newInstance(element.getClass(), size);
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = element;
        }
        return resultArray;
    }

    public static void main(String[] args) {
        double[] arr = new double[] {
                9.0, 7.0, 6.0, 3.0, 1.0
        };

        double compDouble = 6.0;
        int result = binaryDescendRangeSearchEqualRightFindLeft(arr, compDouble);
        System.out.println(result);

    }

}
