package cn.edu.ecnu.basic;


import cn.edu.ecnu.basic.cumulate.CumulativeFunction;
import cn.edu.ecnu.io.print.MyPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static <T> T getRandomElement(List<T> elementList, int sampleSize) {
        int lowerBound = 0;
        int upperBound = elementList.size() - 1;
        Integer index = getRandomInteger(lowerBound, upperBound);
        return elementList.get(index);
    }

    public static <T> T getRandomElement(List<T> elementList) {
        return getRandomElement(elementList, 1);
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

    public static List<Integer> getRandomIntegerArrayWithoutRepeat(Integer lowerBound, Integer upperBound, int samplingSize) {
        int domainSize = upperBound - lowerBound + 1;
        if (samplingSize > domainSize) {
            throw new RuntimeException("The sampling size is larger than domain size!");
        }
        List<Integer> result = new ArrayList<>(samplingSize);
        int samplingPosition;
        Integer samplingElement;
        int residualMaxIndex = domainSize - 1;
        List<Integer> randomList = BasicArray.getIncreaseIntegerNumberList(lowerBound, 1, upperBound);
        for (int i = 0; i < samplingSize; i++) {
            samplingPosition = getRandomInteger(0, residualMaxIndex);

            samplingElement = randomList.remove(samplingPosition);
            result.add(samplingElement);
            -- residualMaxIndex;
        }

        return result;
    }


    /**
     *
     * @param cumulatedValues 是一系列排序好的小于1的正小数，第一个数为0
     * @return
     */
    public static Integer getRandomIndexGivenCumulatedPoint(Double[] cumulatedValues) {
        double randomValue = Math.random();
        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.FORMER);
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
        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.LATTER);
    }


    // todo: 整数随机选取算法
    public static Integer getRandomIndexGivenStatisticPoint(Integer[] statisticValues) {
        int len  = statisticValues.length;
        Integer[] cumulatedValues = CumulativeFunction.getCumulativeDistribution(statisticValues);
//        double randomValue = Math.random();
//        return BasicSearch.binarySearch(cumulatedValues, randomValue, BasicSearch.FORMER);
        Integer randomInteger = getRandomInteger(1, cumulatedValues[len - 1]);
        return BasicSearch.binarySearch(cumulatedValues, randomInteger, BasicSearch.LATTER);
    }


    public static void main(String[] args) {
        Integer[] result = getRandomIntegerArray(0, 100, 20);
        MyPrint.showIntegerArray(result);
    }

}
