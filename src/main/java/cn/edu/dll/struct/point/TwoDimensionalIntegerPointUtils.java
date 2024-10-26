package cn.edu.dll.struct.point;

import java.util.*;

public class TwoDimensionalIntegerPointUtils {
    public static TwoDimensionalIntegerPoint getExchangeXYIndex(TwoDimensionalIntegerPoint point) {
        Integer xIndex = point.getXIndex();
        Integer yIndex = point.getYIndex();
        return new TwoDimensionalIntegerPoint(yIndex, xIndex);
    }

    public static Collection<TwoDimensionalIntegerPoint> getExchangeXYIndexList(Collection<? extends TwoDimensionalIntegerPoint> originalCollection) {
        int size = originalCollection.size();
        List<TwoDimensionalIntegerPoint> resultList = new ArrayList<>(size);
        for (TwoDimensionalIntegerPoint point : originalCollection) {
            resultList.add(getExchangeXYIndex(point));
        }
        return resultList;
    }

    public static TreeMap<Integer, TreeSet<TwoDimensionalIntegerPoint>> groupByXIndex(Collection<TwoDimensionalIntegerPoint> originalCollection) {
        TreeMap<Integer, TreeSet<TwoDimensionalIntegerPoint>> resultMap = new TreeMap<>();
        Integer tempX;
        TreeSet<TwoDimensionalIntegerPoint> tempTreeSet;
        for (TwoDimensionalIntegerPoint point : originalCollection) {
            tempX = point.getXIndex();
            tempTreeSet = resultMap.get(tempX);
            if (tempTreeSet == null) {
                tempTreeSet = new TreeSet<>();
                tempTreeSet.add(point);
                resultMap.put(tempX, tempTreeSet);
            } else {
                tempTreeSet.add(point);
            }
        }
        return resultMap;
    }

    public static  TreeMap<Integer, TreeSet<TwoDimensionalIntegerPoint>> groupByYIndex(Collection<? extends TwoDimensionalIntegerPoint> originalCollection) {
        TreeMap<Integer, TreeSet<TwoDimensionalIntegerPoint>> resultMap = new TreeMap<>();
        Integer tempY;
        TreeSet<TwoDimensionalIntegerPoint> tempTreeSet;
        for (TwoDimensionalIntegerPoint point : originalCollection) {
            tempY = point.getYIndex();
            tempTreeSet = resultMap.get(tempY);
            if (tempTreeSet == null) {
                tempTreeSet = new TreeSet<>();
                tempTreeSet.add(point);
                resultMap.put(tempY, tempTreeSet);
            } else {
                tempTreeSet.add(point);
            }
        }
        return resultMap;
    }

    public static List<TwoDimensionalIntegerPoint> toSimpleIntegerPoint(List<TwoDimensionalDoublePoint> doubleTrajectory) {
        List<TwoDimensionalIntegerPoint> result = new ArrayList<>(doubleTrajectory.size());
        for (TwoDimensionalDoublePoint doublePoint : doubleTrajectory) {
            result.add(new TwoDimensionalIntegerPoint((int)Math.round(doublePoint.getXIndex()), (int)Math.round(doublePoint.getYIndex())));
        }
        return result;
    }

}
