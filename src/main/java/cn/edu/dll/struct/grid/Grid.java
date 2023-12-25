package cn.edu.dll.struct.grid;


import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.struct.point.DoublePoint;
import cn.edu.dll.struct.point.IntegerPoint;
import cn.edu.dll.struct.point.TwoDimensionalDoublePoint;
import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;
import cn.edu.dll.basic.BasicArrayUtil;
import cn.edu.dll.basic.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Grid {
    @Deprecated
    public static Integer[] toGridIndex(Double gridLen, Double... indexes) {
        Integer[] result = new Integer[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            result[i] = (int)Math.floor(indexes[i] / gridLen);
        }
        return result;
    }

    public static Integer[] toGridIndex(Double gridLen, Double[] leftBoundArray, Double[] indexArray) {
        Integer[] result = new Integer[indexArray.length];
        for (int i = 0; i < indexArray.length; i++) {
            result[i] = (int)Math.floor((indexArray[i] - leftBoundArray[i]) / gridLen);
        }
        return result;
    }

    @Deprecated
    public static List<TwoDimensionalIntegerPoint> toIntegerPoint(List<TwoDimensionalDoublePoint> doubleValuePointList, double gridLength) {
        int size = doubleValuePointList.size();
        Integer[] indexes;
        List<TwoDimensionalIntegerPoint> resultList = new ArrayList<>(size);
        for (TwoDimensionalDoublePoint doubleValuePoint : doubleValuePointList) {
            indexes = Grid.toGridIndex(gridLength, doubleValuePoint.getValueArray());
            resultList.add(new TwoDimensionalIntegerPoint(indexes));
        }
        return resultList;
    }

    public static List<TwoDimensionalIntegerPoint> toIntegerPoint(List<TwoDimensionalDoublePoint> doubleValuePointList, Double[] leftBoundArray, double gridLength) {
        int size = doubleValuePointList.size();
        Integer[] indexes;
        List<TwoDimensionalIntegerPoint> resultList = new ArrayList<>(size);
        for (DoublePoint doubleValuePoint : doubleValuePointList) {
            indexes = Grid.toGridIndex(gridLength, leftBoundArray, doubleValuePoint.getValueArray());
            resultList.add(new TwoDimensionalIntegerPoint(indexes));
        }
        return resultList;
    }

    /**
     * 将给定的cell中心点随机化到对应的网格中的任意点
     * @param centralPointList
     * @return
     */
    public static List<TwoDimensionalDoublePoint> randomizeInGrid(List<TwoDimensionalIntegerPoint> centralPointList) {
        int size = centralPointList.size();
        Integer[] valueArray;
        Double tempInnerX, tempInnerY;
        TwoDimensionalDoublePoint tempIntegerPoint;
        List<TwoDimensionalDoublePoint> resultList = new ArrayList<>(size);
        for (TwoDimensionalIntegerPoint centerPoint : centralPointList) {
            valueArray = centerPoint.getValueArray();
            tempInnerX = RandomUtil.getRandomDouble(0.0, 1.0);
            tempInnerY = RandomUtil.getRandomDouble(0.0, 1.0);
            tempIntegerPoint = new TwoDimensionalDoublePoint(tempInnerX+valueArray[0], tempInnerY+valueArray[1]);
            resultList.add(tempIntegerPoint);
        }
        return resultList;
    }

    /**
     * 返回整数点的小数表示
     * @param integerValuePointList
     * @param leftBoundArray
     * @param gridLength
     * @param isCenter true表示返回cell的中心点，false表示返回cell中均匀随机选取的点
     * @return
     */
    public static List<TwoDimensionalDoublePoint> toDoublePoint(List<TwoDimensionalIntegerPoint> integerValuePointList, Double[] leftBoundArray, double gridLength, boolean isCenter) {
        int size = integerValuePointList.size();
        double tempInnerX, tempInnerY;
        TwoDimensionalDoublePoint tempDoublePoint;
        Integer[] valueArray;
        List<TwoDimensionalDoublePoint> resultList = new ArrayList<>(size);
        if (isCenter) {
            for (IntegerPoint integerValuePoint : integerValuePointList) {
                valueArray = integerValuePoint.getValueArray();
                tempDoublePoint = new TwoDimensionalDoublePoint(leftBoundArray[0]+(0.5+valueArray[0])*gridLength, leftBoundArray[0]+(0.5+valueArray[1])*gridLength);
                resultList.add(tempDoublePoint);
            }
        } else {
            for (IntegerPoint integerValuePoint : integerValuePointList) {
                valueArray = integerValuePoint.getValueArray();
                tempInnerX = RandomUtil.getRandomDouble(0.0, gridLength);
                tempInnerY = RandomUtil.getRandomDouble(0.0, gridLength);
                tempDoublePoint = new TwoDimensionalDoublePoint(leftBoundArray[0]+tempInnerX+valueArray[0]*gridLength, leftBoundArray[0]+tempInnerY+valueArray[1]*gridLength);
                resultList.add(tempDoublePoint);
            }
        }
        return resultList;
    }

    /**
     * 根据给定的长度和区域左下角的整数cell点，生成边长为sizeD的正方形区域
     * @param sizeD
     * @param xLeft
     * @param yLeft
     * @return
     */
    public static List<TwoDimensionalIntegerPoint> generateTwoDimensionalIntegerPoint(Integer sizeD, Integer xLeft, Integer yLeft) {
        List<TwoDimensionalIntegerPoint> resultList = new ArrayList<>(sizeD * sizeD);
        Integer xIndex, yIndex;
        for (int i = 0; i < sizeD; i++) {
            xIndex = xLeft + i;
            for (int j = 0; j < sizeD; j++) {
                yIndex = yLeft + j;
                resultList.add(new TwoDimensionalIntegerPoint(xIndex, yIndex));
            }
        }
        return resultList;
    }

    public static Double[] getDistinct1NormDistanceGivenIntegerSquareGridLength(Integer gridLength) {
        int gridLenMinusOne = gridLength - 1;
        return BasicArrayUtil.getIncreaseDoubleNumberArray(0.0, 1.0, gridLenMinusOne*2.0);
    }

    public static Double[] getDistinct2NormDistanceGivenIntegerSquareGridLength(Integer gridLength) {
        TreeSet<Double> distanceSet = new TreeSet<>();
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j <= i; j++) {
                distanceSet.add(Math.sqrt(i*i + j*j));
            }
        }
        return distanceSet.toArray(new Double[0]);
    }

//    // todo: to be done.
//    public static Double[] getDistinct2NormTotalCellSumDistanceGivenIntegerSquareGridLength(Integer gridLength) {
//        Double[] allTypeDistance = getDistinct2NormDistanceGivenIntegerSquareGridLength(gridLength);
//        TreeSet<Double> allSumDistance = new TreeSet<>();
//
//    }



    public static void main(String[] args) {
        int len = 10;
        double gridLen = 5.0;
        Double[] inputValues = new Double[len];
        Integer[] outputValues;
        for (int i = 0; i < len; i++) {
            inputValues[i] = RandomUtil.getRandomDouble(-100.0, 100.0);
        }
        outputValues = Grid.toGridIndex(gridLen, inputValues);
        MyPrint.showDoubleArray(inputValues);
        MyPrint.showIntegerArray(outputValues);
    }
}
