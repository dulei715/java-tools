package cn.edu.ecnu.struct;


import cn.edu.ecnu.basic.RandomUtil;
import cn.edu.ecnu.io.print.MyPrint;
import cn.edu.ecnu.struct.point.IntegerPoint;
import cn.edu.ecnu.struct.point.Point;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static Integer[] toGridIndex(Double gridLen, Double... indexes) {
        Integer[] result = new Integer[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            result[i] = (int)Math.floor(indexes[i] / gridLen);
        }
        return result;
    }

    public static List<? extends IntegerPoint> toIntegerPoint(List<? extends Point> doubleValuePointList, double gridLength) {
        int size = doubleValuePointList.size();
        Integer[] indexes;
        List<IntegerPoint> resultList = new ArrayList<>(size);
        for (Point doubleValuePoint : doubleValuePointList) {
            indexes = Grid.toGridIndex(gridLength, doubleValuePoint.getValueArray());
            resultList.add(new IntegerPoint(indexes));
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
