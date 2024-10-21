package cn.edu.dll.basic;


import cn.edu.dll.basic.cumulate.CumulativeFunction;
import cn.edu.dll.io.print.MyPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class RandomUtil {

    /**
     *
     * @param lowerBound （包含在内）
     * @param upperBound （不包含在内）
     * @return
     */
    public static Double getRandomDouble(Double lowerBound, Double upperBound) {
        double randomValue = Math.random();
        double realValue = randomValue * (upperBound - lowerBound) + lowerBound;
        return realValue;
    }

    /**
     *
     * @param lowerBound (包含在内)
     * @param upperBound (包含在内)
     * @return
     */
    public static Integer getRandomInteger(Integer lowerBound, Integer upperBound) {
        double randomValue = Math.random();
        double realValue = randomValue * (upperBound + 1 - lowerBound) + lowerBound;
        Integer result = (int) Math.floor(realValue);
        return result;
    }

    public static Boolean isChosen(Double probability) {
        Double position = Math.random();
        if (position < probability) {
            return true;
        }
        return false;
    }

    public static <T> List<T> getRandomElement(List<T> elementList, int sampleSize) {
        int lowerBound = 0;
        int upperBound = elementList.size() - 1;
        Integer index;
        List<T> sampleElementList = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            index = getRandomInteger(lowerBound, upperBound);
            sampleElementList.add(elementList.get(index));
        }
        return sampleElementList;
    }

    public static <T> T getRandomElement(List<T> elementList) {
        List<T> randomElementList = getRandomElement(elementList, 1);
        return randomElementList.get(0);
    }


    public static Integer getTwoPartRandomInteger(Integer lowerBoundA, Integer upperBoundA, Integer lowerBoundB, Integer upperBoundB) {
        int firstPartSize = upperBoundA - lowerBoundA + 1;
        int secondPartSize = upperBoundB - lowerBoundB + 1;
        if (firstPartSize < 0 || secondPartSize < 0) {
            throw new RuntimeException("Size of some Parts is less than 0!");
        }
        double randomPart = Math.random();
        if (randomPart < firstPartSize * 1.0 / (firstPartSize + secondPartSize)) {
            // 返回第一部分
            return getRandomInteger(lowerBoundA, upperBoundA);
        }
        // 返回第二部分
        return getRandomInteger(lowerBoundB, upperBoundB);
    }

    /**
     * 返回随机整数数组（元素可以重复）
     * @param lowerBound
     * @param upperBound
     * @param arraySize
     * @return
     */
    public static Integer[] getRandomIntegerArray(Integer lowerBound, Integer upperBound, int arraySize) {
        Integer[] resultArray = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = getRandomInteger(lowerBound, upperBound);
        }
        return resultArray;
    }

    /**
     * 返回随机小数数组（元素可以重复）
     * @param lowerBound
     * @param upperBound
     * @param arraySize
     * @return
     */
    public static Double[] getRandomDoubleArray(Double lowerBound, Double upperBound, int arraySize) {
        Double[] resultArray = new Double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = getRandomDouble(lowerBound, upperBound);
        }
        return resultArray;
    }

    public static List<Integer> getRandomIntegerArrayWithoutRepeat(Integer lowerBound, Integer upperBound, int samplingSize) {
        int domainSize = upperBound - lowerBound + 1;
        if (samplingSize > domainSize) {
            throw new RuntimeException("The sampling size is larger than domain size!");
        }
        List<Integer> result = new ArrayList<>(samplingSize);
        int samplingPosition;
        Integer samplingElement;
        int residualMaxIndex = domainSize - 1;
        List<Integer> randomList = BasicArrayUtil.getIncreaseIntegerNumberList(lowerBound, 1, upperBound);
        for (int i = 0; i < samplingSize; i++) {
            samplingPosition = getRandomInteger(0, residualMaxIndex);

            samplingElement = randomList.remove(samplingPosition);
            result.add(samplingElement);
            -- residualMaxIndex;
        }

        return result;
    }
    public static int[] getRandomIntArrayWithoutRepeat(int lowerBound, int upperBound, int samplingSize) {
        int domainSize = upperBound - lowerBound + 1;
        if (samplingSize > domainSize) {
            throw new RuntimeException("The sampling size is larger than domain size!");
        }
        int[] result = new int[samplingSize];
        int samplingPosition;
        Integer samplingElement;
        int residualMaxIndex = domainSize - 1;
        List<Integer> randomList = BasicArrayUtil.getIncreaseIntegerNumberList(lowerBound, 1, upperBound);
        for (int i = 0; i < samplingSize; i++) {
            samplingPosition = getRandomInteger(0, residualMaxIndex);

            samplingElement = randomList.remove(samplingPosition);
            result[i] = samplingElement;
            -- residualMaxIndex;
        }

        return result;
    }

    /**
     * 获取给定0到upperBoundValue之间的arraySize个随机数
     * @param arraySize
     * @param upperBoundValue
     * @return
     */
    public static Double[] getRandomDoubleArrayWithValuesInGivenRange(Integer arraySize, Double upperBoundValue) {
        Integer pointSize = arraySize - 1;
        Double[] pointArray = getRandomDoubleArray(0D, upperBoundValue, pointSize);
        Arrays.sort(pointArray);
        Double[] result = new Double[arraySize];
        Double beforeValue = 0D;
        int i;
        for (i = 0; i < pointSize; i++) {
            result[i] = pointArray[i] - beforeValue;
            beforeValue = pointArray[i];
        }
        result[i] = upperBoundValue - beforeValue;
        return result;
    }


    /**
     *
     * @param cumulatedValues 是一系列排序好的小于1的正小数，第一个数为0
     * @return
     */
    public static Integer getRandomIndexGivenCumulatedPoint(Double[] cumulatedValues) {
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.FORMER);
        return BasicSearch.binaryFormerSearchWithMinimalIndex(cumulatedValues, randomValue);
    }

    /**
     *
     * @param statisticValues 是一系列和为1的正小数
     * @return
     */
    public static Integer getRandomIndexGivenStatisticPoint(Double[] statisticValues) {
//        double sum = BasicCalculation.getSum(statisticValues);
//        if (sum != 1.0) {
//            throw new RuntimeException("The sum of statistic values is not equal to 1!");
//        }
        int len = statisticValues.length;
        Double[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(statisticValues);
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.LATTER);
        return BasicSearch.binaryLatterSearchWithMinimalIndex(cumulatedValues, randomValue);
    }

    /**
     * 这里的countValue可以是整数也可以是小数
     * @param countValues
     * @return
     */
    public static Integer getRandomIndexGivenCountPoint(final Double[] countValues) {
        int len = countValues.length;
        Double[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(countValues);
        BasicArrayUtil.linearTransform(cumulatedValues, 1.0/cumulatedValues[len-1], 0.0);
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.LATTER);
        return BasicSearch.binaryLatterSearchWithMinimalIndex(cumulatedValues, randomValue);
    }

    public static Integer getRandomIndexGivenCountPoint(final Double[] countValues, int startIndex, int endIndex) {
        int len = endIndex - startIndex + 1;
        Double[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(countValues, startIndex, endIndex);
        BasicArrayUtil.linearTransform(cumulatedValues, 1.0/cumulatedValues[len-1], 0.0);
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.LATTER);
        int bias =  BasicSearch.binaryLatterSearchWithMinimalIndex(cumulatedValues, randomValue);
        return startIndex + bias;
    }


    public static Integer getRandomIndexGivenCountPoint(final List<Double> countValueList) {
        int len = countValueList.size();
        Double[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(countValueList.toArray(new Double[0]));
        BasicArrayUtil.linearTransform(cumulatedValues, 1.0/cumulatedValues[len-1], 0.0);
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.LATTER);
        return BasicSearch.binaryLatterSearchWithMinimalIndex(cumulatedValues, randomValue);
    }

    /**
     * 给定一组累积值，最后一个是所有的和。先将所有元素除以最后一个元素，再调用getRandomIndexGivenCumulativePoint
     * @param cumulativeCountValues
     * @return
     */
    public static Integer getRandomIndexGivenCumulativeCountPoint(final Double[] cumulativeCountValues) {
        int len = cumulativeCountValues.length;
        Double[] cumulativeValues = BasicArrayUtil.getLinearTransform(cumulativeCountValues, 1.0 / cumulativeCountValues[len - 1], 0.0);
        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulativeValues, randomValue, BasicSearch.LATTER);
        return BasicSearch.binaryLatterSearchWithMinimalIndex(cumulativeValues, randomValue);
    }


    // todo: 整数随机选取算法
    public static Integer getRandomIndexGivenStatisticPoint(Integer[] statisticValues) {
        int len  = statisticValues.length;
        Integer[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(statisticValues);
//        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.FORMER);
        Integer randomInteger = getRandomInteger(1, cumulatedValues[len - 1]);
//        return BasicSearch.binarySearch(cumulatedValues, randomInteger, BasicSearch.LATTER);
        return BasicSearch.binaryLatterSearchWithMinimalIndex(cumulatedValues, randomInteger);
    }


    public static void main(String[] args) {
        Integer[] result = getRandomIntegerArray(0, 100, 20);
        MyPrint.showIntegerArray(result);
    }

}
