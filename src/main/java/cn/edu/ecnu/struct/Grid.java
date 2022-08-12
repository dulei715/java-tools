package cn.edu.ecnu.struct;


import cn.edu.ecnu.basic.RandomUtil;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.Point;
import cn.edu.ecnu.struct.point.IntegerPoint;
import cn.edu.ecnu.struct.point.TwoDimensionalDoublePoint;
import cn.edu.ecnu.struct.point.TwoDimensionalIntegerPoint;
import org.apache.commons.math3.ml.clustering.DoublePoint;

import java.util.ArrayList;
import java.util.List;

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
        for (Point doubleValuePoint : doubleValuePointList) {
            indexes = Grid.toGridIndex(gridLength, leftBoundArray, doubleValuePoint.getValueArray());
            resultList.add(new TwoDimensionalIntegerPoint(indexes));
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
        int tempX, tempY;
        double tempInnerX, tempInnerY;
        TwoDimensionalDoublePoint tempDoublePoint;
        Integer[] valueArray;
        List<TwoDimensionalDoublePoint> resultList = new ArrayList<>(size);
        if (isCenter) {
            for (IntegerPoint integerValuePoint : integerValuePointList) {
                valueArray = integerValuePoint.getValueArray();
                tempDoublePoint = new TwoDimensionalDoublePoint(leftBoundArray[0]+0.5+valueArray[0], leftBoundArray[0]+0.5+valueArray[1]);
                resultList.add(tempDoublePoint);
            }
        } else {
            for (IntegerPoint integerValuePoint : integerValuePointList) {
                valueArray = integerValuePoint.getValueArray();
                tempInnerX = RandomUtil.getRandomDouble(0.0, gridLength);
                tempInnerY = RandomUtil.getRandomDouble(0.0, gridLength);
                tempDoublePoint = new TwoDimensionalDoublePoint(leftBoundArray[0]+tempInnerX+valueArray[0], leftBoundArray[0]+tempInnerY+valueArray[1]);
                resultList.add(tempDoublePoint);
            }
        }
        return resultList;
    }

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
