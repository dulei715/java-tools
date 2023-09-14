package cn.edu.ecnu.basic;

import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.statistic.StatisticTool;
import org.junit.Test;

import java.util.TreeMap;

public class StatisticToolTest {
    @Test
    public void fun1() {
        Double[][] values = new Double[][]{
          new Double[]{1.0, 2.0, 3.0, 4.0},
          new Double[]{5.0, 6.0, 7.0, 8.0},
          new Double[]{9.0, 10.0, 11.0, 12.0},
          new Double[]{13.0, 14.0, 15.0, 16.0},
        };
        Double[][] result = StatisticTool.getTwoDimensionalSmooth(values, 0.2);
        MyPrint.show2DimensionDoubleArray(result);
    }

    @Test
    public void fun2() {
        Double[] initialCountArray = new Double[]{1.0/3, 1.0/3, 1.0/3};
        Integer[] noiseCountArray = new Integer[]{10, 20, 15, 5};
        Double[][] matrix = new Double[][]{
                {0.2, 0.2, 0.3},
                {0.4, 0.5, 0.3},
                {0.3, 0.1, 0.2},
                {0.1, 0.2, 0.2},
        };
        Double tempLikelihood = StatisticTool.getLogLikelihood(initialCountArray, matrix);
//        System.out.println(tempLikelihood);

//        Double[] result = getExpectationMaximization(matrix, noiseCountArray, 0.1, initialCountArray);
//        MyPrint.showDoubleArray(result);

        for (int i = 0; i < 10; i++) {
            MyPrint.showDoubleArray(StatisticTool.getExpectationMaximization(matrix, noiseCountArray, 0.0001*(10-i), initialCountArray));
        }

        MyPrint.showSplitLine("*", 150);
        Integer[] binomialCoefficients = new Integer[]{1, 2, 1};

        for (int i = 0; i < 10; i++) {
            MyPrint.showDoubleArray(StatisticTool.getExpectationMaximizationSmooth(matrix, noiseCountArray, 0.0001*(10-i), binomialCoefficients, initialCountArray));
        }

    }

    @Test
    public void fun3() {
        Double[] initialCountArray = new Double[]{1.0/3, 1.0/3, 1.0/3};
        Double[][] matrix = new Double[][]{
                {0.2, 0.2, 0.3},
                {0.4, 0.5, 0.3},
                {0.3, 0.1, 0.2},
                {0.1, 0.2, 0.2},
        };
        Double tempLikelihood = StatisticTool.getLogLikelihood(initialCountArray, matrix);
        System.out.println(tempLikelihood);
    }

    @Test
    public void fun4() {
        TreeMap<Integer, Double> initialCountMap = new TreeMap<>();
        initialCountMap.put(0, 1.0/3);
        initialCountMap.put(1, 1.0/3);
        initialCountMap.put(2, 1.0/3);

        TreeMap<Integer, TreeMap<Integer, Double>> matrix = new TreeMap<>();

        TreeMap<Integer, Double> tempInnerMap = new TreeMap<>();
        tempInnerMap.put(0, 0.2);
        tempInnerMap.put(1, 0.2);
        tempInnerMap.put(2, 0.3);
        matrix.put(0, tempInnerMap);

        tempInnerMap = new TreeMap<>();
        tempInnerMap.put(0, 0.4);
        tempInnerMap.put(1, 0.5);
        tempInnerMap.put(2, 0.3);
        matrix.put(1, tempInnerMap);

        tempInnerMap = new TreeMap<>();
        tempInnerMap.put(0, 0.3);
        tempInnerMap.put(1, 0.1);
        tempInnerMap.put(2, 0.2);
        matrix.put(2, tempInnerMap);

        tempInnerMap = new TreeMap<>();
        tempInnerMap.put(0, 0.1);
        tempInnerMap.put(1, 0.2);
        tempInnerMap.put(2, 0.2);
        matrix.put(3, tempInnerMap);

//        Double[][] matrix = new Double[][]{
//                {0.2, 0.2, 0.3},
//                {0.4, 0.5, 0.3},
//                {0.3, 0.1, 0.2},
//                {0.1, 0.2, 0.2},
//        };
        Double tempLikelihood = StatisticTool.getLogLikelihood(initialCountMap, matrix);
        System.out.println(tempLikelihood);
    }

}
