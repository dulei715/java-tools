package cn.edu.ecnu.statistic;


import cn.edu.ecnu.basic.BasicArray;
import cn.edu.ecnu.collection.ArraysUtils;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;

import java.util.*;

@SuppressWarnings("ALL")
public class StatisticTool {

    /**
     * 极大似然估计
     * @param value
     * @param matrix
     * @return
     */
    public static Double getLogLikelihood(final Double[] value, final Double[][] matrix) {
        Double sum = 0.0;
        Double innerSum;
        for (int k = 0; k < matrix.length; k++) {
            innerSum = 0.0;
            for (int i = 0; i < value.length; i++) {
                innerSum += value[i] * matrix[k][i];
            }
            sum += Math.log(innerSum);
        }
        return sum;
    }

    @Deprecated
    public static <T,R> Double getLogLikelihood(TreeMap<T, Double> valueMap, TreeMap<R, TreeMap<T, Double>> matrix) {
        Double sum = 0.0;
        Double innerSum;
        R tempR;
        TreeMap<T, Double> tempTValue;
        T tempT;
        Double tempValue;
        for (Map.Entry<R, TreeMap<T, Double>> rTreeMapEntry : matrix.entrySet()) {
            innerSum = 0.0;
            tempR = rTreeMapEntry.getKey();
            tempTValue = rTreeMapEntry.getValue();
            for (Map.Entry<T, Double> tDoubleEntry : tempTValue.entrySet()) {
                tempT = tDoubleEntry.getKey();
                tempValue = tDoubleEntry.getValue();
                innerSum += valueMap.get(tempT) * tempValue;
            }
            sum += Math.log(innerSum);
        }
        return sum;
    }

//    public static Double getLocalLikelihood(final Double[] value, final Double[][] matrix, final Double[] localPoint) {
//        return null;
//    }

    /**
     * 用于一维 Wave mechanism
     * @param values
     * @param binomialCoefficients 必须是奇数个
     * @return
     */
    public static Double[] getSmooth(Double[] values, Integer[] binomialCoefficients) {
        Double[] ratios = new Double[binomialCoefficients.length];
        Double outerRatioSum;
        Integer sum = BasicArray.getSum(binomialCoefficients);
        for (int i = 0; i < ratios.length; i++) {
            ratios[i] = binomialCoefficients[i] * 1.0 / sum;
        }
        Integer midIndex = binomialCoefficients.length / 2;
        Double[] result = new Double[values.length];

        // i记录中心值得位置
        // 处理左侧超出边界
        for (int i = 0; i < midIndex; i++) {
            outerRatioSum = 0.0;
            for (int j = 0; j <= midIndex - i; j++) {
                outerRatioSum += ratios[j];
            }
            result[i] = values[0] * outerRatioSum;
            for (int j = midIndex - i + 1, k = 1; j < ratios.length; j++, k++) {
                result[i] += values[k] * ratios[j];
            }
        }
        // 处理右侧超出边界
        for (int i = result.length - midIndex; i < result.length; i++) {
            outerRatioSum = 0.0;
            for (int j = midIndex + result.length - i - 1; j < ratios.length; j++) {
                outerRatioSum += ratios[j];
            }
            result[i] = values[result.length - 1] * outerRatioSum;
//            for (int j = 0; j < midIndex + result.length - i - 1; j++) {
//                result[i] += values[] * binomialCoefficients[j]
//            }
            for (int j = 0, k = i - midIndex; k < result.length - 1; j++, k++) {
                result[i] += values[k] * ratios[j];
            }
        }
        // 处理中间值
        for (int i = midIndex; i < result.length - midIndex; i++) {
            result[i] = 0.0;
            for (int j = 0; j < ratios.length; j++) {
                result[i] += values[i-midIndex+j] * ratios[j];
            }
        }
        return result;
    }


    /**
     * 这里只考虑用紧邻的元素去平滑中心值。对应一维的二项系数个数为3
     * @param values
     * @param ratioK
     * @return
     */
    public static Double[][] getTwoDimensionalSmooth(Double[][] values, Double ratioK) {
        Double tempDouble = 4 * ratioK + 1;
        Double neighboorRatio = ratioK / tempDouble;
        Double selfRatio = 1 / tempDouble;

        int rowLen = values.length;
        int colLen = values[0].length;
        Double[][] resultStatistic = new Double[rowLen][colLen];

        // 处理四个角
        Double combineRatio = neighboorRatio * 2 + selfRatio;
        resultStatistic[0][0] = values[0][0] * combineRatio + (values[0][1]+values[1][0]) * neighboorRatio;
        resultStatistic[0][colLen-1] = values[0][colLen-1] * combineRatio + (values[0][colLen-2]+values[1][colLen-1]) * neighboorRatio;
        resultStatistic[rowLen-1][0] = values[rowLen-1][0] * combineRatio + (values[rowLen-2][0]+values[rowLen-1][1]) * neighboorRatio;
        resultStatistic[rowLen-1][colLen-1] = values[rowLen-1][colLen-1] * combineRatio + (values[rowLen-1][colLen-2]+values[rowLen-2][colLen-1]) * neighboorRatio;


        // 处理四条边
        combineRatio = neighboorRatio + selfRatio;
        for (int i = 1; i < rowLen-1; i++) {
            resultStatistic[i][0] = values[i][0] * combineRatio + (values[i-1][0] + values[i][1] + values[i+1][0]) * neighboorRatio;
            resultStatistic[i][colLen-1] = values[i][colLen-1] * combineRatio + (values[i-1][colLen-1] + values[i][colLen-2] + values[i+1][colLen-1]) * neighboorRatio;
        }
        for (int j = 1; j < colLen-1; j++) {
            resultStatistic[0][j] = values[0][j] * combineRatio + (values[0][j-1] + values[1][j] + values[0][j+1]) * neighboorRatio;
            resultStatistic[rowLen-1][j] = values[rowLen-1][j] * combineRatio + (values[rowLen-1][j-1] + values[rowLen-2][j] + values[rowLen-1][j+1]) * neighboorRatio;
        }

        // 处理中间值
        for (int i = 1; i < rowLen - 1; i++) {
            for (int j = 1; j < colLen - 1; j++) {
                resultStatistic[i][j] = values[i][j] * selfRatio + (values[i-1][j] + values[i][j-1] + values[i+1][j] + values[i][j+1]) * neighboorRatio;
            }
        }

        return resultStatistic;
    }


    public static Double[] getExpectationMaximization(final Double[][] matrix, final Integer[] noiseValueCountArray, Double stopValue, final Double[] initialValueCountArray) {
        Double[] pValueArray = new Double[initialValueCountArray.length];
        Double[] beforeValueArray = new Double[initialValueCountArray.length];
        Double[] newValueArray = new Double[initialValueCountArray.length];
        System.arraycopy(initialValueCountArray, 0, newValueArray, 0, initialValueCountArray.length);

        Double innerSum, innerInnerSum, pSum, beforeLogLikelihood;
        Double newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        do {
            System.arraycopy(newValueArray, 0, beforeValueArray, 0, newValueArray.length);
            beforeLogLikelihood = newLogLikelihood;
            for (int i = 0; i < pValueArray.length; i++) {
                innerSum = 0.0;
                for (int j = 0; j < noiseValueCountArray.length; j++) {
                    innerInnerSum = 0.0;
                    for (int k = 0; k < beforeValueArray.length; k++) {
                        innerInnerSum += matrix[j][k] * beforeValueArray[k];
                    }
                    innerSum += noiseValueCountArray[j] * matrix[j][i] / innerInnerSum;
                }
                pValueArray[i] = beforeValueArray[i] * innerSum;
            }

            pSum = BasicArray.getSum(pValueArray);

            for (int i = 0; i < pValueArray.length; i++) {
                newValueArray[i] = pValueArray[i] / pSum;
            }
            newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        } while (Math.abs(newLogLikelihood - beforeLogLikelihood) >= stopValue);
        return newValueArray;
    }
//    public static <T, R> Double[] getExpectationMaximization(final TreeMap<Pair<R, T>, Double> matrix, final TreeMap<R, Integer> noiseValueCountMap, Double stopValue, final TreeMap<T, Double> initialValueCountMap) {
//        TreeMap<T, Double> pValueMap = new TreeMap<>();
//        TreeMap<T, Double> beforeValueMap = new TreeMap<>();
//        TreeMap<T, Double> newValueMap = new TreeMap<>();
//        TreeMap<T, Double> tempMapForSwap;
//
//        System.arraycopy(initialValueCountMap, 0, newValueMap, 0, initialValueCountMap.length);
//
//
//        Double innerSum, innerInnerSum, pSum, beforeLogLikelihood;
//        Double newLogLikelihood = getLogLikelihood(newValueMap, matrix);
//        do {
//            System.arraycopy(newValueMap, 0, beforeValueMap, 0, newValueMap.length);
//            beforeLogLikelihood = newLogLikelihood;
//            for (int i = 0; i < pValueMap.length; i++) {
//                innerSum = 0.0;
//                for (int j = 0; j < noiseValueCountMap.length; j++) {
//                    innerInnerSum = 0.0;
//                    for (int k = 0; k < beforeValueMap.length; k++) {
//                        innerInnerSum += matrix[j][k] * beforeValueMap[k];
//                    }
//                    innerSum += noiseValueCountMap[j] * matrix[j][i] / innerInnerSum;
//                }
//                pValueMap[i] = beforeValueMap[i] * innerSum;
//            }
//
//            pSum = BasicArray.getSum(pValueMap);
//
//            for (int i = 0; i < pValueMap.length; i++) {
//                newValueMap[i] = pValueMap[i] / pSum;
//            }
//            newLogLikelihood = getLogLikelihood(newValueMap, matrix);
//        } while (Math.abs(newLogLikelihood - beforeLogLikelihood) >= stopValue);
//        return newValueMap;
//    }



    /**
     *
     * @param matrix 行是 noise value 列是 raw value
     * @param noiseValueCountArray
     * @param stopValue
     * @param binomialCoefficients
     * @param initialValueCountArray
     * @return
     */
    public static Double[] getExpectationMaximizationSmooth(final Double[][] matrix, final Integer[] noiseValueCountArray, Double stopValue, Integer[] binomialCoefficients, final Double[] initialValueCountArray) {
        Double[] pValueArray = new Double[initialValueCountArray.length];
        Double[] beforeValueArray = new Double[initialValueCountArray.length];
        Double[] newValueArray = new Double[initialValueCountArray.length];
        System.arraycopy(initialValueCountArray, 0, newValueArray, 0, initialValueCountArray.length);

        Double innerSum, innerInnerSum, pSum, beforeLogLikelihood;
        Double newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        do {
            System.arraycopy(newValueArray, 0, beforeValueArray, 0, newValueArray.length);
            beforeLogLikelihood = newLogLikelihood;
            for (int i = 0; i < pValueArray.length; i++) {
                innerSum = 0.0;
                for (int j = 0; j < noiseValueCountArray.length; j++) {
                    innerInnerSum = 0.0;
                    for (int k = 0; k < beforeValueArray.length; k++) {
                        innerInnerSum += matrix[j][k] * beforeValueArray[k];
                    }
                    innerSum += noiseValueCountArray[j] * matrix[j][i] / innerInnerSum;
                }
                pValueArray[i] = beforeValueArray[i] * innerSum;
            }

            pSum = BasicArray.getSum(pValueArray);

            for (int i = 0; i < pValueArray.length; i++) {
                newValueArray[i] = pValueArray[i] / pSum;
            }
            newValueArray = getSmooth(newValueArray, binomialCoefficients);
            newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        } while (Math.abs(newLogLikelihood - beforeLogLikelihood) >= stopValue);
        return newValueArray;
    }
    public static Double[] getTwoDimensionalExpectationMaximizationSmooth(final Double[][] matrix, final Integer[] noiseValueCountArray, Double stopValue, final Double[] initialValueCountArray, double kParameter, int xIndexSize, int yIndexSize) {
        Double[] pValueArray = new Double[initialValueCountArray.length];
        Double[] beforeValueArray = new Double[initialValueCountArray.length];
        Double[] newValueArray = new Double[initialValueCountArray.length];

        Double[][] newTwoDimensionalValueArray = new Double[xIndexSize][yIndexSize];

        System.arraycopy(initialValueCountArray, 0, newValueArray, 0, initialValueCountArray.length);

        Double innerSum, innerInnerSum, pSum, beforeLogLikelihood;
        Double newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        do {
            System.arraycopy(newValueArray, 0, beforeValueArray, 0, newValueArray.length);
            beforeLogLikelihood = newLogLikelihood;
            for (int i = 0; i < pValueArray.length; i++) {
                innerSum = 0.0;
                for (int j = 0; j < noiseValueCountArray.length; j++) {
                    innerInnerSum = 0.0;
                    for (int k = 0; k < beforeValueArray.length; k++) {
                        innerInnerSum += matrix[j][k] * beforeValueArray[k];
                    }
                    innerSum += noiseValueCountArray[j] * matrix[j][i] / innerInnerSum;
                }
                pValueArray[i] = beforeValueArray[i] * innerSum;
            }

            pSum = BasicArray.getSum(pValueArray);

            for (int i = 0; i < pValueArray.length; i++) {
                newValueArray[i] = pValueArray[i] / pSum;
            }
            ArraysUtils.reshapeAndSet(newValueArray, newTwoDimensionalValueArray);
            newTwoDimensionalValueArray = getTwoDimensionalSmooth(newTwoDimensionalValueArray, kParameter);
            ArraysUtils.shiftAndSet(newTwoDimensionalValueArray, newValueArray);
            newLogLikelihood = getLogLikelihood(newValueArray, matrix);
        } while (Math.abs(newLogLikelihood - beforeLogLikelihood) >= stopValue);
        return newValueArray;
    }



    /**
     * 统计个数。元素的种类由collection指定
     * @param collection
     * @return
     */
    @Deprecated
    public static <T> Map<T, Integer> countHistogramNumber(Collection<T> collection) {
        Map<T, Integer> resultMap = new TreeMap<>();
        TwoDimensionalIntegerPoint tempPoint;
        Integer tempCount;
        for (T point : collection) {
            tempCount = resultMap.get(point);
            if (tempCount == null) {
                resultMap.put(point, 1);
            } else {
                ++tempCount;
                resultMap.put(point, tempCount);
            }
        }
        return resultMap;
    }

    /**
     * 统计个数。元素的种类由elementTypeList指定
     * @param elementTypeList
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> Integer[] countHistogramNumber(List<T> elementTypeList, Collection<T> collection) {
        Map<T, Integer> resultMap = new TreeMap<>();
        TwoDimensionalIntegerPoint tempPoint;
        Integer tempCount;
        for (T element : elementTypeList) {
            resultMap.put(element, 0);
        }
        for (T point : collection) {
            tempCount = resultMap.get(point);
            if (tempCount != null) {
                ++tempCount;
                resultMap.put(point, tempCount);
            }
        }
        Integer[] resultArray = new Integer[elementTypeList.size()];
        int k = 0;
        for (T element : elementTypeList) {
            resultArray[k++] = resultMap.get(element);
        }
        return resultArray;
    }

    /**
     * 统计占比
     * @param collection
     * @return
     */
    public static <T> Map<T, Double> countHistogramRatio(Collection<T> collection) {
        double size = collection.size() * 1.0;
        Map<T, Integer> countResultMap = countHistogramNumber(collection);
        Map<T, Double> ratioResultMap = new TreeMap<>();
        for (Map.Entry<T, Integer> entry : countResultMap.entrySet()) {
            ratioResultMap.put(entry.getKey(), entry.getValue()/size);
        }
        return ratioResultMap;
    }




//    public static void main(String[] args) {
////        Double[] initialCountArray = new Double[]{50.0/3, 50.0/3, 50.0/3};
//        Double[] initialCountArray = new Double[]{1.0/3, 1.0/3, 1.0/3};
//        Integer[] noiseCountArray = new Integer[]{10, 20, 15, 5};
//        Double[][] matrix = new Double[][]{
//                {0.2, 0.2, 0.3},
//                {0.4, 0.5, 0.3},
//                {0.3, 0.1, 0.2},
//                {0.1, 0.2, 0.2},
//        };
//        Double tempLikelihood = getLogLikelihood(initialCountArray, matrix);
////        System.out.println(tempLikelihood);
//
////        Double[] result = getExpectationMaximization(matrix, noiseCountArray, 0.1, initialCountArray);
////        MyPrint.showDoubleArray(result);
//
//        for (int i = 0; i < 10; i++) {
//            MyPrint.showDoubleArray(getExpectationMaximization(matrix, noiseCountArray, 0.0001*(10-i), initialCountArray));
//        }
//
//        MyPrint.showSplitLine("*", 150);
//        Integer[] binomialCoefficients = new Integer[]{1, 2, 1};
//
//        for (int i = 0; i < 10; i++) {
//            MyPrint.showDoubleArray(getExpectationMaximizationSmooth(matrix, noiseCountArray, 0.0001*(10-i), binomialCoefficients, initialCountArray));
//        }
//
//
//    }

    public static void main1(String[] args) {
//        Double[] values = new Double[]{4.0, 12.0, 8.0, 4.0, 16.0, 12.0};
//        Integer[] binomialCoefficients = new Integer[]{1, 2, 1};
//        Double[] values = new Double[]{32.0, 16.0, 48.0, 80.0, 128.0, 112.0};
        Double[] values = new Double[]{32.0, 16.0, 48.0, 80.0, 128.0, 112.0, 128.0, 640.0, 16.0};
        Integer[] binomialCoefficients = new Integer[]{1, 4, 6, 4, 1};
        Double[] result = getSmooth(values, binomialCoefficients);
        MyPrint.showDoubleArray(result);
    }

}
